package com.madforgolf.controller;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;
import com.madforgolf.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	// http://localhost:8080/controller/test (x)
	// http://localhost:8080/controller/board/test (o)
	// http://localhost:8080/board/test (o , 서버 모듈 설정후)
	//	@RequestMapping("/test")
	//	public void test() {
	//		log.info("test() 호출");
	//	}
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	// 서비스객체 필요(의존적)
	@Inject
	private ProductService service;
	
	
	// http://localhost:8080/product/listAll
	// 상품 리스트 - 조회 (GET)
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	public String listAllGET(ProductVO vo, PageVO vo2, Model model, HttpSession session) throws Exception {
		log.info("listAllGET() 호출");
		log.info("카테고리 : " + vo.getCategory());
		log.info("성별 : " + vo.getGender());
		
		// 서비스 - 글전체 목록 가져오는 메서드
		List<ProductVO> productList = service.getProductListAll(vo, vo2);
		log.info("상품 개수 : "+ productList.size() + "개");
		
		// 상품을 카테고리로 분류하기 위해 category 변수명으로 변수를 view로 넘겨줌
		model.addAttribute("category", vo.getCategory());
		// 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("productList", productList);
		
		// 세션객체 - isUpdate 정보전달
		session.setAttribute("isUpdate", false);
		
		// ==================================================== 페이징 처리 ====================================================
		// DB 내 모든 상품의 총 개수 
		Integer totalCnt = service.getTotalCnt();
		log.info("DB 내 모든 상품의 총 개수 : " + totalCnt + "개");
		
		// 페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo2);				// 페이징 처리 하단부 정보를 vo에 받아오고 
		pm.setTotalCnt(totalCnt);   // calData() 페이징처리에 필요한 계산식 계산 메서드가 포함된 전체 글 갯수 초기화 메서드 호출
		
		log.info("pmVO : " + pm);
		log.info("pageVO : " + vo2);
		log.info("pm의 값 : " + pm.getStartPage() + ", " + pm.getEndPage());
		
		// 페이징 처리 객체(pm)을 어트리뷰트에 담아서 view로 보냄 
		model.addAttribute("pm", pm);
		// ==================================================== 페이징 처리 ====================================================
		
		log.info("/product/shop -> /product/shop.jsp ");
		return "/product/shop";
	} // 상품 리스트 - 조회 (GET)
	
	
	//상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPageGET(PageVO vo, Model model) throws Exception{
		log.info("listPageGET() 호출");
		log.info("vo : " + vo);
		
		/*
		 * //PageVO 객체 생성
		 */		/*
		 * PageVO vo = new PageVO(); 
		 * vo.setPage(2); //2페이지에 해당하는 글을
		 * vo.setPerPageNum(30); //30개씩 표시
		 */		
		//View페이지로 vo(글의 정보 : Service -> DAO -> mapper과정으로 담아온 데이터를 View로 보내줌) 
		model.addAttribute("ProductList",service.listPage(vo));
		
		//페이징 처리 하단부 정보 저장   
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo); //페이징 처리 하단부 정보를 vo에 받아오고 
		pm.setTotalCnt(512); //calData() 페이징처리에 필요한 계산식 계산 메서드가 포함된 전체 글 갯수 초기화 메서드 호출
		// 512 : DB 값 확인 필요
		
		log.info("pm : " + pm);
		log.info("vo : " + vo);
		
		//model객체에 담아서 view페이지로 페이징 처리 정보 전달 
		model.addAttribute("pm", pm);
		model.addAttribute("vo", vo);
		
		return"/product/shop";
	} // 상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출
	
	
	// 상품등록 페이지 - 이동 (GET)
	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public void productInsertGET() throws Exception {
		log.info("productInsert() 호출");
		log.info("/product/productInsert.jsp 호출");
	} // 상품등록 페이지 - 이동 (GET)
	
	
	// 상품 등록 - 등록 (POST)
	@RequestMapping(value = "/productInsert",method = RequestMethod.POST)
	public String productInsertPOST(ProductVO vo, @ModelAttribute("file") MultipartFile file, HttpServletRequest request) throws Exception{
		log.info("productInsertPOST() 호출");
		
		// 전달된 정보 저장
		log.info("상품 정보 : " + vo);
		
		// 파일 개요
		String fileRealName = file.getOriginalFilename();
		long size = file.getSize();
		log.info("파일명 : " + fileRealName);
		log.info("용량(Byte) : " + size);

		// 파일 등록 - 등록되는 파일 경로
		// String uploadFolder = "C:\\Users\\ITWILL\\git\\New_MadForGolf\\src\\main\\webapp\\resources\\product_img";
		// 경로 직접 입력은 경로 일치 필요
		// => 메서드로 절대 경로 구하기 -> 경로 일치 필요없음
		String uploadFolder = request.getServletContext().getRealPath("resources/product_img");
		// 파일 저장 경로 : D:\workspace_sts6\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MadForGolf\resources\product_img
		log.info("파일 저장 경로" + uploadFolder);

		// 파일 등록 - 파일 이름 랜덤 생성(이름 중복 방지)
		UUID uuid = UUID.randomUUID();
		log.info("UUID : " + uuid);
		String[] uuids = uuid.toString().split("-");
		String uniqueName = uuids[0];
		
		// 파일 등록 - 확장자명 만들기
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
		
		log.info("생성된 고유문자열 : " + uniqueName);
		log.info("확장자명 : " + fileExtension);
		
		// 파일 등록
		java.io.File saveFile = new java.io.File(uploadFolder + "/" + uniqueName + fileExtension);
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
			log.info("파일 등록 완료!");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
				
		// 서비스 - DB에 상품 등록
		vo.setProd_img(uniqueName + fileExtension);
		service.productInsert(vo);
		
		// 페이지 이동(리스트) 화면,주소 모두 변경
		return "redirect:/";
	} // 상품 등록 - 등록 (POST)
	
	
	
	
	
	
	
	
	
	
		// http://localhost:8080/board/regist
		// 글쓰기 - GET
		@RequestMapping(value = "/regist",method = RequestMethod.GET)
		public void registerGET() throws Exception{
			log.info(" registerGET() 호출 ");
			log.info(" /board/regist (get) -> /board/regist.jsp");
			
		}
		
		// 글쓰기 - POST
		@RequestMapping(value = "/regist",method = RequestMethod.POST)
		public String registerPOST(BoardVO vo,RedirectAttributes rttr /*Model model*/) throws Exception{
			log.info("registerPOST() 호출");
			// 한글처리 (필터)
			// 전달된 정보 저장
			log.info("글쓰기 정보 : "+vo);
			
			// 서비스 - 글쓰기 동작
			//service.boardWrite(vo);
			
			log.info(" 글쓰기 완료 !! ");
			
			//model.addAttribute("msg", "OK");
			
			// RedirectAttributes 객체 => rediret 페이지 이동시에만 사용가능
			rttr.addFlashAttribute("msg", "OK");
			// -> 1회성 데이터 (체크용), URL에 표시 x
			
			// 페이지 이동(리스트) 화면,주소 모두 변경
			
			//return "/board/success";
			//return "redirect:/board/listAll?msg=OK";
//			return "redirect:/board/listAll";
			return "redirect:/board/listPage";
		}
	
	// http://localhost:8080/board/read?bno=12
	// 글 본문보기 - GET
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(HttpSession session,@RequestParam("bno") int bno,Model model /* @ModelAttribute("bno") int bno */) throws Exception {
		log.info("readGET() 호출");
		// 전달정보 (bno)
		log.info(" bno : "+bno);
		
		//boolean isUpdate = false;
		log.info(" isUPdate : "+session.getAttribute("isUpdate"));
		
		boolean isUpdate = (boolean)session.getAttribute("isUpdate");
		
		//if(isUpdate == false) {
		if(!isUpdate) {
			// 서비스 - updateReadCount(BNO)
			service.updateReadCount(bno);
			log.info(" 조회수 1증가! ");
			session.setAttribute("isUpdate", true);
		}
		
		// 서비스 - getBoard(int)
		BoardVO vo = service.getBoard(bno);
		
		log.info(vo+"");
		model.addAttribute("vo", vo);
		
		log.info("/board/read -> /board/read.jsp");
	}
	
	// 글 수정하기 - GET (기존의 정보 조회 출력+수정할 정보 입력)
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno")  int bno,Model model) throws Exception{
		// 전달정보 저장(bno)
		log.info("@@@"+bno);
		
		// 서비스 - 게시판 글 정보를 가져오는 메서드
		// 연결된 뷰에 정보 전달(Model객체)
		model.addAttribute("vo", service.getBoard(bno));
		// 페이지 이동(출력) /board/modify
	}
	
	// 글 수정하기 - POST(수정할데이터 처리)
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception {
		log.info(" modifyPOST() 호출 ");
		// 한글처리(생략)		
		// 전달정보 저장(수정할 정보) VO
		log.info("@@수정할정보@@"+vo);
		
		// 서비스 - 글 수정메서드
		int cnt = service.updateBoard(vo);
		
		// 수정성공시 /listAll 페이지 이동
		if(cnt == 1) {
			rttr.addFlashAttribute("msg", "MODOK");
			
//			return "redirect:/board/listAll";
			return "redirect:/board/listPage";
		}else {
			// 예외처리 
			// new NullPointerException();
			return "/board/modify?bno="+vo.getBoard_num();
		}
		
	}
	
	// 글 삭제 - POST
	@RequestMapping(value = "/remove",method = RequestMethod.POST )
	public String removePOST(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception {
		log.info(" removePOST() 호출 ");
		
		// 전달정보 저장(bno)
		log.info("bno : "+bno);
		
		// 서비스 - 글삭제 동작 (bno)
		int result =service.deleteBoard(bno);
		
		if(result == 1) {
			rttr.addFlashAttribute("msg", "DELOK");
		}
		
		// 글 리스트 페이지 이동		
//		return "redirect:/board/listAll";
		return "redirect:/board/listPage";
	}
	

	
		
		
	
	
	

}


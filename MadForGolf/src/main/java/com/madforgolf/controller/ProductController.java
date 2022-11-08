package com.madforgolf.controller;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.LikeVO;
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
	// @RequestMapping("/test")
	// public void test() {
	// log.info("test() 호출");
	// }

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	// 서비스객체 필요(의존적)
	@Inject
	private ProductService service;

//===============================================최신순 상품목록 조회:"/listAll"==========================================================

	// http://localhost:8080/product/listAll
	// 상품 리스트 - 조회 (GET)
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllGET(ProductVO vo, PageVO vo2, Model model, HttpSession session) throws Exception {
		log.info("listAllGET() 호출");
		log.info("카테고리 : " + vo.getCategory());
		log.info("성별 : " + vo.getGender());

		// 서비스 - 글전체 목록 가져오는 메서드
		List<ProductVO> productList = service.getProductListAll(vo, vo2);
		log.info("상품 개수 : " + productList.size() + "개");
		
		// 상품을 카테고리로 분류하기 위해 category 변수명으로 변수를 view로 넘겨줌
		model.addAttribute("category", vo.getCategory());
		model.addAttribute("gender", vo.getGender());
		
		// 지역인증 되면, model로 위도/경도 넘기기 + header카테고리 주소값에도 위도경도 추가 + shop성별 카테고리에도 위도경도 추가 


		// 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("productList", productList);

		// 세션객체 - isUpdate 정보전달
		session.setAttribute("isUpdate", false);
		

		// ==================================================== 페이징 처리
		// ====================================================
		// DB 내 모든 상품의 총 개수
		Integer totalCnt = service.getTotalCnt(vo);
		log.info("DB 내 상품의 총 개수 : " + totalCnt + "개");

		// 페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo2); // 페이징 처리 하단부 정보를 vo에 받아오고
		pm.setTotalCnt(totalCnt); // calData() 페이징처리에 필요한 계산식 계산 메서드가 포함된 전체 글 갯수 초기화 메서드 호출

		log.info("pmVO : " + pm);
		log.info("pageVO : " + vo2);

		// 페이징 처리 객체(pm)을 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("pm", pm);
		// ==================================================== 페이징 처리
		// ====================================================

		log.info("/product/shop -> /product/shop.jsp ");
		return "/product/shop";
	} // 상품 리스트 - 조회 (GET)
//===============================================최신순 상품목록 조회:"/listAll"==========================================================

//===============================================인기순 상품목록 조회:"/listLike"==========================================================
	// http://localhost:8080/product/listLike
	// 상품 리스트 - 조회 (GET)
	@RequestMapping(value = "/listLike", method = RequestMethod.GET)
	public String listLikeGET(ProductVO vo, PageVO vo2, Model model, HttpSession session) throws Exception {
		log.info("listLikeGET() 호출");
		log.info("카테고리 : " + vo.getCategory());
		log.info("성별 : " + vo.getGender());

		// 서비스 - 글전체 목록 가져오는 메서드
		List<ProductVO> productList = service.getProductListAll2(vo, vo2);
		log.info("상품 개수 : " + productList.size() + "개");

		// 상품을 카테고리로 분류하기 위해 category 변수명으로 변수를 view로 넘겨줌
		// 최신순 정렬 위해 필요한 값 -> #{category}, #{gender}
		model.addAttribute("category", vo.getCategory());

		model.addAttribute("gender", vo.getGender());
		// 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("productList", productList);

		// 세션객체 - isUpdate 정보전달
		session.setAttribute("isUpdate", false);

		// ==================================================== 페이징 처리
		// ====================================================
		// DB 내 모든 상품의 총 개수
		Integer totalCnt = service.getTotalCnt(vo);
		log.info("DB 내 상품의 총 개수 : " + totalCnt + "개");

		// 페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo2); // 페이징 처리 하단부 정보를 vo에 받아오고
		pm.setTotalCnt(totalCnt); // calData() 페이징처리에 필요한 계산식 계산 메서드가 포함된 전체 글 갯수 초기화 메서드 호출

		log.info("pmVO : " + pm);
		log.info("pageVO : " + vo2);

		// 페이징 처리 객체(pm)을 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("pm", pm);
		// ==================================================== 페이징 처리
		// ====================================================

		log.info("/product/shop -> /product/shop.jsp ");
		return "/product/shop";
	} // 상품 리스트 - 조회 (GET)

//===============================================인기순 상품목록 조회:"/listLike"==========================================================

	// 상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPageGET(PageVO vo, Model model) throws Exception {
		log.info("listPageGET() 호출");
		log.info("vo : " + vo);

		/*
		 * //PageVO 객체 생성
		 */ /*
			 * PageVO vo = new PageVO(); vo.setPage(2); //2페이지에 해당하는 글을
			 * vo.setPerPageNum(30); //30개씩 표시
			 */
		// View페이지로 vo(글의 정보 : Service -> DAO -> mapper과정으로 담아온 데이터를 View로 보내줌)
		model.addAttribute("ProductList", service.listPage(vo));

		// 페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo); // 페이징 처리 하단부 정보를 vo에 받아오고
		pm.setTotalCnt(512); // calData() 페이징처리에 필요한 계산식 계산 메서드가 포함된 전체 글 갯수 초기화 메서드 호출
		// 512 : DB 값 확인 필요

		log.info("pm : " + pm);
		log.info("vo : " + vo);

		// model객체에 담아서 view페이지로 페이징 처리 정보 전달
		model.addAttribute("pm", pm);
		model.addAttribute("vo", vo);

		return "/product/shop";
	} // 상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출

	// 상품 상세 페이지 - 이동(GET) 
		@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
		public String productDetail(ProductVO vo, Model model, HttpSession session) throws Exception {
			log.info("productDetail(ProductVO vo) 호출");
			int result=-1;
			String user_id = (String)session.getAttribute("user_id");


			ProductVO product = service.productDetail(vo);
			model.addAttribute("product", product);

			LikeVO lvo = new LikeVO();
			lvo.setProd_num(product.getProd_num());
			lvo.setBuyer_id(user_id);
			log.info(lvo+"");


			LikeVO like = service.bringLike(lvo);
			log.info(like+"");
			if(like != null) {
			}else {
				like = new LikeVO();
				like.setCheck(0);
			}
			model.addAttribute("result",like);


			return "/product/shopDetails";

		} // 상품 상세 페이지 - 이동(GET)

	// 상품등록 페이지 - 이동 (GET)
	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public void productInsertGET() throws Exception {
		log.info("productInsert() 호출");
		log.info("/product/productInsert.jsp 호출");
	} // 상품등록 페이지 - 이동 (GET)

	
	// 파일업로드(1개짜리) 입니다. 공부하실 분 참고하세요.
	// 상품 등록 - 등록 (POST)
//	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
//	public String productInsertPOST(ProductVO vo, @ModelAttribute("file") MultipartFile file,
//			HttpServletRequest request) throws Exception {
//		log.info("productInsertPOST() 호출");
//
//		// 전달된 정보 저장
//		log.info("상품 정보 : " + vo);
//
//		// 파일 개요
//		String fileRealName = file.getOriginalFilename();
//		long size = file.getSize();
//		log.info("파일명 : " + fileRealName);
//		log.info("용량(Byte) : " + size);
//
//		// 파일 등록 - 등록되는 파일 경로
//		// String uploadFolder =
//		// "C:\\Users\\ITWILL\\git\\New_MadForGolf\\src\\main\\webapp\\resources\\product_img";
//		// 경로 직접 입력은 경로 일치 필요
//		// => 메서드로 절대 경로 구하기 -> 경로 일치 필요없음
//		String uploadFolder = request.getServletContext().getRealPath("resources/product_img");
//		// 파일 저장 경로 :
//		// D:\workspace_sts6\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MadForGolf\resources\product_img
//		log.info("파일 저장 경로" + uploadFolder);
//
//		// 파일 등록 - 파일 이름 랜덤 생성(이름 중복 방지)
//		UUID uuid = UUID.randomUUID();
//		log.info("UUID : " + uuid);
//		String[] uuids = uuid.toString().split("-");
//		String uniqueName = uuids[0];
//
//		// 파일 등록 - 확장자명 만들기
//		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
//
//		log.info("생성된 고유문자열 : " + uniqueName);
//		log.info("확장자명 : " + fileExtension);
//
//		// 파일 등록
//		java.io.File saveFile = new java.io.File(uploadFolder + "/" + uniqueName + fileExtension);
//		try {
//			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
//			log.info("파일 등록 완료!");
//		} catch (Exception e) {
//			log.info(e.getMessage());
//		}
//
//		// 서비스 - DB에 상품 등록
//		vo.setProd_img(uniqueName + fileExtension);
//		service.productInsert(vo);
//
//		// 페이지 이동(리스트) 화면,주소 모두 변경
//		return "redirect:/";
//	} // 상품 등록 - 등록 (POST)

	
	// 상품 등록 - 등록 (POST) - 다중 업로드
	@RequestMapping(value = "/productInsert", method = RequestMethod.POST)
	public String productInsertPOST(MultipartHttpServletRequest multi, ProductVO vo, HttpServletRequest request) throws Exception {
		log.info("productInsertPOST() 호출");
		
		// log.info("multi : " + multi);

		// 파일의 정보를 저장하는 MAP
		Map map = new HashMap();
		
		Enumeration enu = multi.getParameterNames(); // 파일정보 x
		// log.info("enu : " + enu);
		
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			log.info("name : " + name);
			String value = multi.getParameter(name);
			log.info("value : " + value);
			map.put(name, value);
		}
		
		// 굳이 이렇게 해야하나...
		log.info("map : " + map);
		vo.setSeller_id((String)map.get("seller_id"));
		vo.setProd_name((String)map.get("prod_name"));
		vo.setPrice(Integer.parseInt((String)map.get("price")));
		vo.setDetail((String)map.get("detail"));
		vo.setCondition((String)map.get("condition"));
		vo.setCategory((String)map.get("category"));
		vo.setGender(Integer.parseInt((String)map.get("gender")));
		// 전달정보(파라미터값)을 MAP에 저장 끝
		
		// 업로드 파일 처리
		fileProcess(multi, vo, request);
		
		service.productInsert(vo);
		
		return "redirect:/";
	}
	
	// 전달된 파일 처리 전용 메서드
	public List<String> fileProcess(MultipartHttpServletRequest multi, ProductVO vo, HttpServletRequest request) throws Exception {
		log.info("첨부파일 처리 시작");
		
		// 파일정보를 저장하는 리스트(리턴)
		List<String> fileList = new ArrayList<String>();
		
		// 전달된 파일정보를 받아서 처리
		Iterator<String> fileNames = multi.getFileNames();
		// log.info("fileNames : " + fileNames);
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next(); // 파일의 파라미터명
			log.info("fileName : " + fileName);
			
			MultipartFile mFile = multi.getFile(fileName); // 업로드된 파일정보를 가져오기
			String oFileName = mFile.getOriginalFilename();
			log.info("oFileName : " + oFileName);
			
			// 파일 등록 - 파일 이름 랜덤 생성(이름 중복 방지)
			UUID uuid = UUID.randomUUID();
			log.info("UUID : " + uuid);
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			log.info("생성된 고유문자열 : " + uniqueName);
	
			// 파일 등록 - 확장자명 만들기
			String fileExtension = oFileName.substring(oFileName.lastIndexOf("."), oFileName.length());
			log.info("확장자명 : " + fileExtension);
			
			// 파일 등록 - 고유한 이름 만들기
			String uFileName = uniqueName + fileExtension;
			log.info("고유한 이름 : " + uFileName);
			
			switch(fileName) {
				case "file1" : vo.setProd_img(uFileName); break;
				case "file2" : vo.setProd_img2(uFileName); break;
				case "file3" : vo.setProd_img3(uFileName); break;
			}
			log.info("image1 : " + vo.getProd_img());
			log.info("image2 : " + vo.getProd_img2());
			log.info("image3 : " + vo.getProd_img3());
			
			// 업로드 될 파일의 이름들을 저장
			fileList.add(uFileName);
			log.info("fileList" + fileList);
			
			// 파일 업로드
			String uploadFolder1 = "C:\\Users\\ITWILL\\git\\New_MadForGolf\\MadForGolf11\\src\\main\\webapp\\resources\\product_img";
			// 속도가 느려 초반에 엑박뜸 and 경로 일치 필요 => but, 깃허브 연동 o
			String uploadFolder2 = request.getServletContext().getRealPath("resources/product_img");
			// 메서드를 통한 경로 => 속도가 빠름, 경로 일치 불필요 => but, 깃허브 연동 x
			// 파일 저장 경로 : D:\workspace_sts6\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MadForGolf\resources\product_img
			// => 둘 다 필요
			
			// 파일 생성
			File file1 = new File(uploadFolder1 + "\\" + uFileName);
			File file2 = new File(uploadFolder2 + "\\" + uFileName);
				
			if(mFile.getSize() != 0) { // 첨부파일이 있을 때				
				mFile.transferTo(file1); // 첨부파일로 전달된 정보를 파일로 전달
				mFile.transferTo(file2); // 첨부파일로 전달된 정보를 파일로 전달
				log.info("파일 업로드 성공");
			} // if
			
		} // while
		
		if(vo.getProd_img2() == null) {
			vo.setProd_img2(vo.getProd_img());
		}
		if(vo.getProd_img3() == null) {
			vo.setProd_img3(vo.getProd_img());
		}
		
		log.info("첨부파일 처리 끝");
		return fileList;
	} // 상품 등록 - 등록 (POST)
	
	
	// 상품작성 수정하기 - GET (기존의 정보 조회 출력+수정할 정보 입력)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyProductGET(ProductVO vo, Model model) throws Exception {
		log.info("modifyProductGET() 호출");
		
		// 연결된 뷰에 정보 전달(Model객체)
		model.addAttribute("product", service.productDetail(vo));
		
		// 페이지 이동(출력) /product/productUpdate.jsp
		return "/product/productUpdate";
	}
	
	
	// 상품작성 수정하기 - POST (수정할데이터 처리)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyProductPOST(
			@RequestParam("oldfile1") String oldfile1, @RequestParam("oldfile2") String oldfile2,
			@RequestParam("oldfile3") String oldfile3, ProductVO vo, RedirectAttributes rttr,
			MultipartHttpServletRequest multi, HttpServletRequest request) throws Exception {
		log.info("modifyProductPOST() 호출");
		
		// 전달정보 저장(수정할 정보) VO
		log.info("수정할 정보 : " + vo);
		
		// 파일의 정보를 저장하는 MAP
		Map map = new HashMap();
		
		Enumeration enu = multi.getParameterNames(); // 파일정보 x
		
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			log.info("name : " + name);
			String value = multi.getParameter(name);
			log.info("value : " + value);
			map.put(name, value);
		}
				
		// 굳이 이렇게 해야하나...
		log.info("map : " + map);
		vo.setProd_num(Integer.parseInt((String)map.get("prod_num")));
		// vo.setSeller_id((String)map.get("seller_id"));
		vo.setProd_name((String)map.get("prod_name"));
		vo.setPrice(Integer.parseInt((String)map.get("price")));
		vo.setDetail((String)map.get("detail"));
		vo.setCondition((String)map.get("condition"));
		vo.setCategory((String)map.get("category"));
		vo.setGender(Integer.parseInt((String)map.get("gender")));
		vo.setProd_img(oldfile1);
		vo.setProd_img2(oldfile2);
		vo.setProd_img3(oldfile3);
		// 전달정보(파라미터값)을 MAP에 저장 끝
		
		// 업로드 파일 처리
		fileProcess(multi, vo, request, oldfile1, oldfile2, oldfile3);
		
		// 서비스 - 상품정보 수정
		int cnt = service.updateProduct(vo);
		log.info("cnt : " + cnt);
		
		if (cnt == 1) {
			// 수정 성공
			return "redirect:/product/productDetail?prod_num=" + vo.getProd_num();
		} else {
			// 수정 실패
			return "redirect:/product/modify?prod_num=" + vo.getProd_num();
		}
		

	} 
	
	// 전달된 파일 처리 전용 메서드 - 오버로딩(oldfile)
		public List<String> fileProcess(
				MultipartHttpServletRequest multi, ProductVO vo, HttpServletRequest request,
				String oldfile1, String oldfile2, String oldfile3) throws Exception {
			log.info("첨부파일 처리 시작");
			
			// 파일정보를 저장하는 리스트(리턴)
			List<String> fileList = new ArrayList<String>();
			
			// 전달된 파일정보를 받아서 처리
			Iterator<String> fileNames = multi.getFileNames();
			// log.info("fileNames : " + fileNames);
			
			while(fileNames.hasNext()) {
				String fileName = fileNames.next(); // 파일의 파라미터명
				log.info("fileName : " + fileName);
				
				MultipartFile mFile = multi.getFile(fileName); // 업로드된 파일정보를 가져오기
				String oFileName = mFile.getOriginalFilename();
				log.info("oFileName : " + oFileName);
				
				if(!oFileName.equals("")) {
					// 파일 업로드 경로
					String uploadFolder1 = "C:\\Users\\ITWILL\\git\\New_MadForGolf1\\MadForGolf11\\src\\main\\webapp\\resources\\product_img";
					// 속도가 느려 초반에 엑박뜸 and 경로 일치 필요 => but, 깃허브 연동 o
					String uploadFolder2 = request.getServletContext().getRealPath("resources/product_img");
					// 메서드를 통한 경로 => 속도가 빠름, 경로 일치 불필요 => but, 깃허브 연동 x
					// 파일 저장 경로 : D:\workspace_sts6\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MadForGolf\resources\product_img
					// => 둘 다 필요
					
					// 파일 등록 - 파일 이름 랜덤 생성(이름 중복 방지)
					UUID uuid = UUID.randomUUID();
					log.info("UUID : " + uuid);
					String[] uuids = uuid.toString().split("-");
					String uniqueName = uuids[0];
					log.info("생성된 고유문자열 : " + uniqueName);
		
					// 파일 등록 - 확장자명 만들기
					String fileExtension = oFileName.substring(oFileName.lastIndexOf("."), oFileName.length());
					log.info("확장자명 : " + fileExtension);
				
					// 파일 등록 - 고유한 이름 만들기
					String uFileName = uniqueName + fileExtension;
					log.info("고유한 이름 : " + uFileName);
					
					switch(fileName) {
						case "file1" : {
							File oldDeleteFile1 = new File(uploadFolder1 + "\\" + oldfile1);
							oldDeleteFile1.delete();
							File oldDeleteFile2 = new File(uploadFolder2 + "\\" + oldfile1);
							oldDeleteFile2.delete();
							vo.setProd_img(uFileName);
							break;
						}
						case "file2" : {
							File oldDeleteFile1 = new File(uploadFolder1 + "\\" + oldfile2);
							oldDeleteFile1.delete();
							File oldDeleteFile2 = new File(uploadFolder2 + "\\" + oldfile2);
							oldDeleteFile2.delete();
							vo.setProd_img2(uFileName);
							break;
						}
						case "file3" : {
							File oldDeleteFile1 = new File(uploadFolder1 + "\\" + oldfile3);
							oldDeleteFile1.delete();
							File oldDeleteFile2 = new File(uploadFolder2 + "\\" + oldfile3);
							oldDeleteFile2.delete();
							vo.setProd_img3(uFileName);
							break;
						}
					}
					log.info("image1 : " + vo.getProd_img());
					log.info("image2 : " + vo.getProd_img2());
					log.info("image3 : " + vo.getProd_img3());
					
					// 업로드 될 파일의 이름들을 저장
					fileList.add(uFileName);
					log.info("fileList" + fileList);
					
					// 파일 생성
					File file1 = new File(uploadFolder1 + "\\" + uFileName); // 학원에서 사용할 때 주석 풀면 됩니다.
					File file2 = new File(uploadFolder2 + "\\" + uFileName);
					
					if(mFile.getSize() != 0) { // 첨부파일이 있을 때				
						mFile.transferTo(file1); // 첨부파일로 전달된 정보를 파일로 전달  // 학원에서 사용할 때 주석 풀면 됩니다.
						mFile.transferTo(file2); 
						log.info("파일 업로드 성공");
					} // if
				} // if(oFileName)
			} // while
			
			log.info("첨부파일 처리 끝");
			return fileList;
		} // 상품작성 수정하기 - POST (수정할데이터 처리)
	
	// 상품작성 삭제 - POST
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removeProductPOST(@RequestParam("prod_num") int prod_num,@RequestParam("category") String category,ProductVO vo,PageVO vo2,RedirectAttributes rttr,Model model) throws Exception {
		log.info(" removeProductPOST() 호출 ");

		// 전달정보 저장(bno)
		log.info("prod_num : " + prod_num);
		log.info("category:"+category);

		// 서비스 - 글삭제 동작 (bno)
		int result = service.deleteBoard(prod_num);

		if (result == 1) {
			rttr.addFlashAttribute("msg", "DELOK");

		}

		// 글 리스트 페이지 이동
//		return "redirect:/board/listAll";
		return "redirect:/product/listAll?category="+category+"&page=1";
	}
	
//=========================메인화면 상품리스트=================================	
	// http://localhost:8080/product 
		// 상품 리스트 - 조회 (GET)
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public void listMainGET(ProductVO vo,Model model, HttpSession session) throws Exception {
			log.info("listMainGET() 호출");


			// 서비스 - 글전체 목록 가져오는 메서드
			List<ProductVO> productList = service.listMain(vo);
			log.info("상품 개수 : " + productList.size() + "개");
			
			// 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄
			model.addAttribute("productList", productList);

			// 세션객체 - isUpdate 정보전달
			session.setAttribute("isUpdate", false);
			



			log.info("/index -> index.jsp");

		} // 상품 리스트 - 조회 (GET)
	
	
	
	

//=========================메인화면 상품리스트=================================
		

		
//=========================찜하기=================================

		
		
		
//좋아요
		@ResponseBody
		@RequestMapping(value="/like",method=RequestMethod.GET)
		public int likePOST(ProductVO pvo,HttpSession session, Model model) {
			log.info("좋아요 체크 실행 @@@@@@@@");
			int result=-1;
			String user_id = (String)session.getAttribute("user_id");
			if(user_id == null) {
				return result;
			}
					
					
			LikeVO vo = new LikeVO();
			vo.setBuyer_id(user_id);
			vo.setProd_num(pvo.getProduct_num());
					
			result = service.insertLike(vo);
			log.info(vo+"############");
					
			session.setAttribute("result", result);
					
//			model.addAttribute("user_id",user_id);
//			model.addAttribute("vo", vo);
//			model.addAttribute("result",result);
			return result;
		}
		
		
//=========================찜하기=================================
		
		
		
				
//-------------------------상품 판매관리/구매관리--------------------------------- : 수정중 ..
	  
	  
//게시판 리스트(페이징 처리) - GET :초기에 판매관리 누르면 판매내역 뜨는 페이지 보여주기
	  
	  @RequestMapping(value = "/listProductAll", method = RequestMethod.GET) 
	  public String listProductAllGET(Model model,PageVO vo,HttpSession session)throws Exception
	  { log.info(" 1. controller - listProductAllGET ");
	  
	  String user_id = (String)session.getAttribute("user_id");
	  log.info("############"+user_id);
	  
	  session.setAttribute("user_id", user_id);
	  model.addAttribute("buyProductList", service.listBuyPage(vo));
	  
	  
	  //페이징 처리 하단부 정보 저장 
	  PageMakerVO pm = new PageMakerVO(); pm.setVo(vo);
	  pm.setTotalCnt(385); model.addAttribute("pm", pm);
	  
	  session.setAttribute("isUpdate", false); //조회수 때문에 주는 것
	  
	  return "/product/productList"; }
	  
	 

//-------------------------상품 판매관리/구매관리---------------------------------
		
		
		
		

		
	// http://localhost:8080/board/regist
	// 글쓰기 - GET
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info(" registerGET() 호출 ");
		log.info(" /board/regist (get) -> /board/regist.jsp");

	}

	// 글쓰기 - POST
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr /* Model model */) throws Exception {
		log.info("registerPOST() 호출");
		// 한글처리 (필터)
		// 전달된 정보 저장
		log.info("글쓰기 정보 : " + vo);

		// 서비스 - 글쓰기 동작
		// service.boardWrite(vo);

		log.info(" 글쓰기 완료 !! ");

		// model.addAttribute("msg", "OK");

		// RedirectAttributes 객체 => rediret 페이지 이동시에만 사용가능
		rttr.addFlashAttribute("msg", "OK");
		// -> 1회성 데이터 (체크용), URL에 표시 x

		// 페이지 이동(리스트) 화면,주소 모두 변경

		// return "/board/success";
		// return "redirect:/board/listAll?msg=OK";
//			return "redirect:/board/listAll";
		return "redirect:/board/listPage";
	}

	/*
	 * // http://localhost:8080/board/read?bno=12 // 글 본문보기 - GET
	 * 
	 * @RequestMapping(value = "/read",method = RequestMethod.GET) public void
	 * readGET(HttpSession session,@RequestParam("bno") int bno,Model
	 * model @ModelAttribute("bno") int bno ) throws Exception {
	 * log.info("readGET() 호출"); // 전달정보 (bno) log.info(" bno : "+bno);
	 * 
	 * //boolean isUpdate = false;
	 * log.info(" isUPdate : "+session.getAttribute("isUpdate"));
	 * 
	 * boolean isUpdate = (boolean)session.getAttribute("isUpdate");
	 * 
	 * //if(isUpdate == false) { if(!isUpdate) { // 서비스 - updateReadCount(BNO)
	 * service.updateReadCount(bno); log.info(" 조회수 1증가! ");
	 * session.setAttribute("isUpdate", true); }
	 * 
	 * // 서비스 - getBoard(int) BoardVO vo = service.getBoard(bno);
	 * 
	 * log.info(vo+""); model.addAttribute("vo", vo);
	 * 
	 * log.info("/board/read -> /board/read.jsp"); }
	 */
	/*
	 * // 글 수정하기 - GET (기존의 정보 조회 출력+수정할 정보 입력)
	 * 
	 * @RequestMapping(value = "/modify",method = RequestMethod.GET) public void
	 * modifyGET(@RequestParam("bno") int bno,Model model) throws Exception{ // 전달정보
	 * 저장(bno) log.info("@@@"+bno);
	 * 
	 * // 서비스 - 게시판 글 정보를 가져오는 메서드 // 연결된 뷰에 정보 전달(Model객체) model.addAttribute("vo",
	 * service.getBoard(bno)); // 페이지 이동(출력) /board/modify }
	 * 
	 * // 글 수정하기 - POST(수정할데이터 처리)
	 * 
	 * @RequestMapping(value = "/modify",method = RequestMethod.POST) public String
	 * modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception {
	 * log.info(" modifyPOST() 호출 "); // 한글처리(생략) // 전달정보 저장(수정할 정보) VO
	 * log.info("@@수정할정보@@"+vo);
	 * 
	 * // 서비스 - 글 수정메서드 int cnt = service.updateBoard(vo);
	 * 
	 * // 수정성공시 /listAll 페이지 이동 if(cnt == 1) { rttr.addFlashAttribute("msg",
	 * "MODOK");
	 * 
	 * // return "redirect:/board/listAll"; return "redirect:/board/listPage"; }else
	 * { // 예외처리 // new NullPointerException(); return
	 * "/board/modify?bno="+vo.getBoard_num(); }
	 * 
	 * }
	 * 
	 * // 글 삭제 - POST
	 * 
	 * @RequestMapping(value = "/remove",method = RequestMethod.POST ) public String
	 * removePOST(@RequestParam("bno") int bno,RedirectAttributes rttr) throws
	 * Exception { log.info(" removePOST() 호출 ");
	 * 
	 * // 전달정보 저장(bno) log.info("bno : "+bno);
	 * 
	 * // 서비스 - 글삭제 동작 (bno) int result =service.deleteBoard(bno);
	 * 
	 * if(result == 1) { rttr.addFlashAttribute("msg", "DELOK"); }
	 * 
	 * // 글 리스트 페이지 이동 // return "redirect:/board/listAll"; return
	 * "redirect:/board/listPage"; }
	 * 
	 */

}

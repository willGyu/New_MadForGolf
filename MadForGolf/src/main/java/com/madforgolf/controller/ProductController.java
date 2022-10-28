package com.madforgolf.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private static final Logger log 
	    = LoggerFactory.getLogger(ProductController.class);
	
	// 서비스객체 필요(의존적)
	@Inject
	private ProductService service;
	
	
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
		
		// RedirectAttributes 객체 => redirect 페이지 이동시에만 사용가능
		rttr.addFlashAttribute("msg", "OK");
		// -> 1회성 데이터 (체크용), URL에 표시 x
		
		// 페이지 이동(리스트) 화면,주소 모두 변경
		
		//return "/board/success";
		//return "redirect:/board/listAll?msg=OK";
//		return "redirect:/board/listAll";
		return "redirect:/board/listPage";
	}

	
	// http://localhost:8080/product/listAll
	// 상품 리스트 - 조회 (GET)
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAllGET(ProductVO vo, Model model, HttpSession session) throws Exception {
		log.info("listAllGET() 호출 ");
		
		// 파라미터 불러오기(카테고리, 성별)
		log.info("category : "+ vo.getCategory());
		log.info("gender : "+ vo.getGender());
		
		// 연결된 view 페이지로 정보 전달
		// model.addAttribute("category", vo.getCategory());

		// 서비스 - 글전체 목록 가져오는 메서드
		List<ProductVO> ProductList = service.getProductListAll(vo);
		
		model.addAttribute("ProductList", ProductList);
		
		// 세션객체 - isUpdate 정보전달
		session.setAttribute("isUpdate", false);
		
		log.info("/Product/shop -> /product/shop.jsp ");
		
		return"/product/shop";
	}
	
	//상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPageGET(PageVO vo,Model model) throws Exception{
		log.info("Controller: listPageGET()호출");
		log.info("vo :"+vo);
		
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
		
		log.info("pm"+pm);
		log.info("vo"+vo);
		
		//model객체에 담아서 view페이지로 페이징 처리 정보 전달 
		model.addAttribute("pm",pm);
		
		return"/product/shop";
	}
	//상품 페이징 리스트(GET) : 페이징처리 완료된 페이지 호출
	
	// 상품등록 페이지  - 이동 (GET)
	@RequestMapping(value = "/productInsert", method = RequestMethod.GET)
	public void productInsertGET() throws Exception {
		log.info("productInsert() 호출");
		log.info("/product/productInsert.jsp 호출");
	}
	
	// 상품 등록 - 등록 (POST)
	@RequestMapping(value = "/productInsert",method = RequestMethod.POST)
	public String productInsertPOST(ProductVO vo) throws Exception{
		log.info("productInsertPOST() 호출");
		
		// 전달된 정보 저장
		log.info("상품 정보 : " + vo);
		
		// 서비스 - 상품등록 동작
		service.productInsert(vo);
		
		// 페이지 이동(리스트) 화면,주소 모두 변경
		return "redirect:/";
	}
	
	


}


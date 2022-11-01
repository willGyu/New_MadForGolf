package com.madforgolf.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madforgolf.domain.ProductVO;
import com.madforgolf.service.HomeService;
import com.madforgolf.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	  
	  // 서비스객체 필요(의존적)
	  @Inject private HomeService service;
	

	  public String home(Locale locale, Model model,ProductVO vo,HttpSession session)throws Exception {
	  log.info("Welcome home! The client locale is {}.", locale);
	  
	  Date date = new Date(); DateFormat dateFormat =
	  DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	  
	  String formattedDate = dateFormat.format(date);
	  
	  model.addAttribute("serverTime", formattedDate );
	  
		// 서비스 - 글전체 목록 가져오는 메서드
		List<ProductVO> productList = service.listMain(vo);
		log.info("상품 개수 : " + productList.size() + "개");

		// 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄
		model.addAttribute("productList", productList);

		// 세션객체 - isUpdate 정보전달
		session.setAttribute("isUpdate", false);
		  
		
		  return "index";
		 
	  }
	  
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "index"; }
	 */	 


	  
	  //=========================메인화면 상품리스트================================= //
	  //http://localhost:8080/product // 상품 리스트 - 조회 (GET)
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET) 
	  public String listMainGET(ProductVO vo,Model model, HttpSession session) throws Exception {
	  log.info("listMainGET() 호출");

	  
	  
	  // 서비스 - 글전체 목록 가져오는 메서드 
	  List<ProductVO> productList = service.listMain(vo);
	  log.info("상품 개수 : " + productList.size() + "개");
	  
	  // 출력되는 상품 리스트를 어트리뷰트에 담아서 view로 보냄 
	  model.addAttribute("productList",productList);
	  
	  // 세션객체 - isUpdate 정보전달 
	  session.setAttribute("isUpdate", false);
	  
	  
	  
	  
	  log.info("/index -> index.jsp");
	  
	  return "index";
	  
	  } // 상품 리스트 - 조회 (GET)
	  
	  
	  
	  
	  
	  //=========================메인화면 상품리스트=================================
	 	 	
}

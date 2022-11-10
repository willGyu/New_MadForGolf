package com.madforgolf.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madforgolf.domain.DealVO;
import com.madforgolf.service.MypageService;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MypageService service;
	
	
	// ---------------------------------- 가계부 ----------------------------------
	// 월별 거래 내역
	@RequestMapping(value="/accountbookMonth")
	public void accountbookMonthGET(HttpSession session, Model model) throws Exception {
		log.info("@@@@@ accountbookMonthGET() 호출");
		
		String user_id = (String)session.getAttribute("user_id");
		String user_name = (String)session.getAttribute("user_name");
		log.info("######### session user_name : "+user_name);
		log.info("@@@@@@@@"+user_id);
		
		// 구매 금액 받아오기
		int purchaseMonth = service.purchaseMonth(user_id);
		model.addAttribute("purchaseMonth", purchaseMonth);
		
		// 판매 금액 받아오기
		int saleMonth = service.saleMonth(user_id);
		model.addAttribute("saleMonth", saleMonth);
		
		// 구매 횟수 받아오기
		int purchaseCnt = service.pruchaseCnt(user_id);
		model.addAttribute("purchaseCnt", purchaseCnt);
		
		// 판매 횟수 받아오기
		int saleCnt = service.saleCnt(user_id);
		model.addAttribute("saleCnt", saleCnt);
		
	}
	
	// 카테고리별 구매 현황
	@RequestMapping(value="/accountbookPurchase")
	public void accountbookPurchase(HttpSession session, Model model) throws Exception {
		log.info("accountbookPurchase() 호출");
		
		String user_id = (String)session.getAttribute("user_id");
		log.info("@@@@@@@@"+user_id);
		
		// 구매 내역 받아오기
		// 드라이버
		int purchaseDriver = service.purchaseDriver(user_id);
		model.addAttribute("purchaseDriver", purchaseDriver);
		
		// 아이언
		int purchaseIron = service.purchaseIron(user_id);
		model.addAttribute("purchaseIron", purchaseIron);
		
		// 유틸리티
		int purchaseUtil = service.purchaseUtil(user_id);
		model.addAttribute("purchaseUtil", purchaseUtil);
		
		// 웨지
		int purchaseWedge = service.purchaseWedge(user_id);
		model.addAttribute("purchaseWedge", purchaseWedge);
		
		// 퍼터
		int purchasePutter = service.purchasePutter(user_id);
		model.addAttribute("purchasePutter", purchasePutter);
		
		// 기타
		int purchaseEtc = service.purchaseEtc(user_id);
		model.addAttribute("purchaseEtc", purchaseEtc);
	}
	
	// 카테고리별 판매 현황
	@RequestMapping(value="/accountbookSale")
	public void accountbookSale(HttpSession session, Model model) throws Exception {
		log.info("accountbookSale() 호출");
		
		String user_id = (String)session.getAttribute("user_id");
		log.info("@@@@@@@@"+user_id);
		
		// 판매 내역 받아오기
		// 드라이버
		int saleDriver = service.saleDriver(user_id);
		model.addAttribute("saleDriver", saleDriver);
		
		// 아이언
		int saleIron = service.saleIron(user_id);
		model.addAttribute("saleIron", saleIron);
		
		// 유틸리티
		int saleUtil = service.saleUtil(user_id);
		model.addAttribute("saleUtil", saleUtil);
		
		// 웨지
		int saleWedge = service.saleWedge(user_id);
		model.addAttribute("saleWedge", saleWedge);
		
		// 퍼터
		int salePutter = service.salePutter(user_id);
		model.addAttribute("salePutter", salePutter);
		
		// 기타
		int saleEtc = service.saleEtc(user_id);
		model.addAttribute("saleEtc", saleEtc);
	}
	// ---------------------------------- 가계부 ----------------------------------
}

package com.madforgolf.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.madforgolf.domain.DealVO;
import com.madforgolf.service.DealService;

@Controller
@RequestMapping("/deal/*")
public class DealController {
	

	private static final Logger log = LoggerFactory.getLogger(DealController.class);
	
	@Inject
	private DealService service;
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	
	//거래 생성
	@RequestMapping(value = "insertDeal",method = RequestMethod.POST)
	public String insertDeal(DealVO vo, HttpSession session) throws Exception{
		
		log.info(" 1. DealController - insertDeal(DealVO) ");
		
		session.setAttribute("prod_num", vo.getProd_num());
		
		log.info(" prod_num 세션값 : "+session.getAttribute("prod_num"));
		
		service.insertDeal(vo);
		
		session.setAttribute("deal_num", vo.getDeal_num());
		log.info(" deal_num 세션값 : "+session.getAttribute("deal_num"));
		
		return "/deal/getDeal";
	}
	
	
	//---------------------------------------------------------------------------------
	
	
	//거래 데이터 가져오기
//	@RequestMapping(value = "getDeal",method = RequestMethod.GET)
//	public String getDeal(HttpSession session) throws Exception{
//		log.info(" 1. DealController - getDeal(DealVO) ");
//		String prod_num = (String)session.getAttribute("prod_num");
//
//		log.info(" prod_num 세션값 : "+session.getAttribute("prod_num"));
//
//		int prod_num = (int)session.getAttribute("prod_num");
//		
//		
//		DealVO dealVo = service.getDeal(prod_num);
//		
//		model.addAttribute("dealVo", dealVo);
//		log.info("dealVo"+dealVo);
//	}
	
	

	
	//---------------------------------------------------------------------------------
	
	
	//거래 데이터 삭제하기
	@RequestMapping(value = "deleteDeal",method = RequestMethod.GET)
	public void deleteDeal(Model model, @RequestParam("deal_num") Integer deal_num) throws Exception{
		log.info(" 1. DealController - deleteDeal(deal_num) ");

		service.deleteDeal(deal_num);
		
	}
	
}

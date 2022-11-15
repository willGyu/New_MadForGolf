package com.madforgolf.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.Service;
import com.madforgolf.domain.ChattingVO;
import com.madforgolf.domain.DealVO;
import com.madforgolf.service.ChattingService;
import com.madforgolf.service.ProductService;

@RestController
public class AjaxController {
	

	private static final Logger log 
							= LoggerFactory.getLogger(AjaxController.class);
	@Inject
	private ProductService service;
	
	@Inject
	ChattingService service2;
	
	//-------------------------상품 상세페이지: 거래전->거래중  // 거래전->거래후---------------------------------
		@ResponseBody
		@RequestMapping(value="/product/BeforeAndDealing",method=RequestMethod.POST,produces = "application/text; charset=UTF-8")
		public ResponseEntity<String> BeforeAndDealing(DealVO dvo,HttpSession session, Model model,@RequestParam("state") String state) throws Exception{
			log.info("AfterDealPOST 실행 @@@@@@@@");
			
			log.info("dvo : " + dvo);
			log.info(state);
			
			String result = service.BeforeAndDealing1(dvo);
			
			log.info(result+"############");
			
			ResponseEntity<String> entity = new ResponseEntity<String>(result, HttpStatus.OK);
			
			return entity;
					
			
		}
	//-------------------------상품 상세페이지: 거래전->거래중  // 거래전->거래후---------------------------------
		@RequestMapping(value = "/product/chattingNum", method = RequestMethod.GET)
		public ResponseEntity<String> chattingNumSelect(ChattingVO vo, HttpSession session) throws Exception {
			log.info("chattingNumSelect() 호출");
			log.info("vo" + vo);
			
			String chattingNum = service2.chattingNumSelect(vo);
			log.info("chattingNum : " + chattingNum);
			
			ResponseEntity<String> entity = new ResponseEntity<String>(chattingNum, HttpStatus.OK);
			
			return entity;
		}
		
		@RequestMapping(value = "/product/deleteChattingNum", method = RequestMethod.GET)
		public ResponseEntity<String> chattingExit(ChattingVO vo, HttpSession session) throws Exception {
			log.info("chattingExit() 호출");
			log.info("vo" + vo);
			
			service2.chattingExit(vo);
			
			String chattingNum = vo.getChattingNum();
			
			ResponseEntity<String> entity = new ResponseEntity<String>(chattingNum, HttpStatus.OK);
			
			return entity;
		}

}

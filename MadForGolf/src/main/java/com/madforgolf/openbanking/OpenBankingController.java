package com.madforgolf.openbanking;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madforgolf.controller.BoardController;
import com.madforgolf.openbanking.domain.RequestTokenVO;
import com.madforgolf.openbanking.domain.ResponseTokenVO;

@Controller
@RequestMapping("/opnebanking/*")
public class OpenBankingController {
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private OpenBankingService openBankingService;
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	
	//토큰발급
	@RequestMapping(value = "/callback",method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO, Model model) throws Exception{
		
		log.info(" 1. OpenBankingController - getToken() ");
		
		//인증
		log.info("########## 본인인증 코드 : "+requestTokenVO.getCode());
		log.info("########## 사용자 권한 범위 : "+requestTokenVO.getScope());
		log.info("########## 사용자 정보 : "+requestTokenVO.getClient_info());
		log.info("########## 난수값 : "+requestTokenVO.getState());
		
		//토큰발급
		ResponseTokenVO responseToken =
			openBankingService.requestToken(requestTokenVO);
		
		//정보들고
		model.addAttribute("responseToken", responseToken);
		return "/openbanking/bank_main";
	}
	
}

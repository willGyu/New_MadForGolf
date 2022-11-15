package com.madforgolf.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.PayResultVO;
import com.madforgolf.domain.PayVO;
import com.madforgolf.service.PayService;

@Controller
@RequestMapping("/pay/*")
public class PayController {
	
private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private PayService service;
	
	//
	@RequestMapping(value="/payInsert", method = RequestMethod.POST)
	public @ResponseBody void insertReply(RedirectAttributes rttr, @RequestBody PayVO vo) throws Exception{
		//전달 정보 저장
		
		service.payInsert(vo);
		
		log.info("##########   *********  payVO : "+vo);
		//rttr.addFlashAttribute("msg", "INSERTOK");
		
		//return "OK";
	}
	
//	//결과페이지로 이동
	@RequestMapping(value="/payResult", method = RequestMethod.POST)
	public String getResult(Model model, PayResultVO vo) throws Exception{
		log.info(vo+"");
		model.addAttribute("vo", vo);
		
		return "/openbanking/payResult";
	}
	
	
}

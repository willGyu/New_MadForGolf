package com.madforgolf.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.DealVO;
import com.madforgolf.domain.ProductVO;
import com.madforgolf.persistence.DealDAO;

@Service
public class DealServiceImpl implements DealService {
	
	

	private static final Logger log = LoggerFactory.getLogger(DealServiceImpl.class);
	
	@Inject
	private DealDAO dao;
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	
	
	//거래 생성
	@Override
	public void insertDeal(DealVO vo) throws Exception {
		log.info(" 2. service - insertDeal(vo) ");
		
		dao.insertDeal(vo);
	}
	
	
	//---------------------------------------------------------------------------------
	
	
	// 거래 수정 (구매자 정보 입력) 
	@Override
	public void updateDeal(Integer deal_num, String buyer_id) throws Exception {
		log.info(" 2. service - updateDeal(vo, buyer_id) ");
		
		dao.updateDeal(deal_num, buyer_id);
	}
	

	//---------------------------------------------------------------------------------
	
	
	// 거래 수정 (거래 - 상품번호 삽입) 
	@Override
	public void addProd_num(int prod_num) throws Exception {
		log.info(" 2. service - addProd_num(prod_num) ");
		
		dao.addProd_num(prod_num);
	}
	

	//---------------------------------------------------------------------------------
	
	
	// 구매자 정보 삭제
	@Override
	public void deleteBuyer(Integer deal_num) throws Exception {
		log.info(" 2. service - deleteBuyer(prod_num) ");
	
		dao.deleteBuyer(deal_num);
	
	}
}

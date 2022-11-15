package com.madforgolf.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.DealVO;
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
	
	
	//거래 정보 가져오기
	@Override
	public DealVO getDeal(String buyer_id) throws Exception {
		log.info(" 2. service - insertDeal(buyer_id) ");
		
		return dao.getDeal(buyer_id);
	}
	

	
	//---------------------------------------------------------------------------------
	
	
	//거래 취소하기(정보 삭제)
	@Override
	public void deleteDeal(Integer deal_num) throws Exception {
		log.info(" 2. service - deleteDeal(buyer_id) ");
		
		dao.deleteDeal(deal_num);
	}
}

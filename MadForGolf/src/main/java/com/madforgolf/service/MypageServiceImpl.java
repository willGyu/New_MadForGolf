package com.madforgolf.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.DealVO;
import com.madforgolf.persistence.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService {
	
	
	private static final Logger log
	= LoggerFactory.getLogger(MemberServiceImpl.class);
	
	
	@Inject
	private MypageDAO dao;
	
	
	// 가계부
	// 월별 구매
	@Override
	public int purchaseMonth(String user_id) throws Exception {
		log.info("purchaseMonth(String user_id) 호출");
		
		log.info("#################"+user_id);
		
				
		return dao.purchaseMonth(user_id);
	}
	
	// 월별 판매
	@Override
	public int saleMonth(String user_id) throws Exception {
		log.info("saleMonth(String user_id) 호출");
		
		log.info("################# sale"+user_id);
		return dao.saleMonth(user_id);
	}
	
	// 월별 구매 횟수
	@Override
	public int pruchaseCnt(String user_id) throws Exception {
		log.info("pruchaseCnt(String user_id) 호출");
		
		log.info("@@@@@@@@@"+user_id);
		return dao.purchaseCnt(user_id);
	}
	
	// 월별 판매 횟수
	@Override
	public int saleCnt(String user_id) throws Exception {
		log.info("saleCnt(String user_id) 호출");
		
		log.info("@@@@@@@@@"+user_id);
		
		return dao.saleCnt(user_id);
	}
	
	// 드라이버 구매
	@Override
	public int purchaseDriver(String user_id) throws Exception {
		log.info("purchaseDriver(String user_id) 호출");
		log.info("@@@@@@@@@@"+user_id);
		
		return dao.purchaseDriver(user_id);
	}

	// 아이언 구매
	@Override
	public int purchaseIron(String user_id) throws Exception {
		return dao.purchaseIron(user_id);
	}
	
	// 유틸리티 구매
	@Override
	public int purchaseUtil(String user_id) throws Exception {
		return dao.purchaseUtil(user_id);
	}
	
	// 웨지 구매
	@Override
	public int purchaseWedge(String user_id) throws Exception {
		return dao.purchaseWedge(user_id);
	}
	
	// 퍼터 구매
	@Override
	public int purchasePutter(String user_id) throws Exception {
		return dao.purchasePutter(user_id);
	}
	
	// 기타용품 구매
	@Override
	public int purchaseEtc(String user_id) throws Exception {
		return dao.purchaseEtc(user_id);
	}
	
	// 드라이버 판매
	@Override
	public int saleDriver(String user_id) throws Exception {
		log.info("saleDriver(String user_id) 호출");
		log.info("@@@@@@@@@@"+user_id);
			
		return dao.saleDriver(user_id);
	}
	
	// 아이언 판매
	@Override
	public int saleIron(String user_id) throws Exception {
		return dao.saleIron(user_id);
	}
	
	// 유틸리티 판매
	@Override
	public int saleUtil(String user_id) throws Exception {
		return dao.saleUtil(user_id);
	}
	
	// 웨지 판매
	@Override
	public int saleWedge(String user_id) throws Exception {
		return dao.saleWedge(user_id);
	}
	
	// 퍼터 판매
	@Override
	public int salePutter(String user_id) throws Exception {
		return dao.salePutter(user_id);
	}
	
	// 기타용품 판매
	@Override
	public int saleEtc(String user_id) throws Exception {
		return dao.saleEtc(user_id);
	}
	// 가계부 끝 !!!!!!!!! 아싸
	
	
	
	
}
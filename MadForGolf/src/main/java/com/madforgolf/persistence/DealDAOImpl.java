package com.madforgolf.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.DealVO;
import com.madforgolf.domain.ProductVO;

@Repository
public class DealDAOImpl implements DealDAO{
	

	private static final Logger log = LoggerFactory.getLogger(DealDAOImpl.class);

	//SqlSession객체(디비연결, mybatis, 매퍼, 자원해제)
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper 가상이름 정의
	private static final String NAMESPACE = "com.madforgolf.mapper.dealMapper";
	
	 
	/////////////////////////////////////////////////////////////////////////////

		
	
	
	//거래 생성
	@Override
	public void insertDeal(DealVO vo) throws Exception {
		log.info(" 3. dao - insertDeal(vo) ");
	
		sqlSession.insert(NAMESPACE+".insertDeal", vo);
	}
	
	
	//-------------------------------------------------------------------------
	
	
	//거래 정보 수정(구매자 정보 입력)
	@Override
	public void updateDeal(Integer deal_num, String buyer_id) throws Exception {
		log.info(" 3. dao - updateDeal(buyer_id) ");
		
		log.info("***** buyer_id :"+buyer_id);
		log.info("***** deal_num :"+deal_num);
		

		Map<String, Object> dealObj = new HashMap<String, Object>();
		dealObj.put("buyer_id", buyer_id);
		dealObj.put("deal_num", deal_num);
		
		
		sqlSession.update(NAMESPACE+".updateDeal", dealObj);
		
	}

	

	//-------------------------------------------------------------------------
	
	
	//거래 정보 수정 (거래 - 상품 번호 입력)
	@Override
	public void addProd_num(int prod_num) {
		log.info(" 3. dao - updateDeal(buyer_id) ");
		
		log.info("******  prod_num : "+ prod_num);
		sqlSession.update(NAMESPACE+".addProd_num", prod_num);

	}


	//-------------------------------------------------------------------------
	
	
	
	// 구매자 정보 삭제
	@Override
	public void deleteBuyer(Integer deal_num) {
		log.info(" 3. dao - deleteBuyer(deal_num) ");
		
		
		sqlSession.update(NAMESPACE+".deleteBuyer", deal_num);

	}
	
	
}

package com.madforgolf.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.DealVO;

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
	
	
	//거래 정보 가져오기
	@Override
	public DealVO getDeal(String buyer_id) {
		log.info(" 3. dao - insertDeal(buyer_id) ");
		
		return sqlSession.selectOne(NAMESPACE+".getDeal", buyer_id);
	}

	
	//-------------------------------------------------------------------------
	
	
	//거래 취소하기(정보 삭제)
	@Override
	public void deleteDeal(Integer deal_num) {
		log.info(" 3. dao - insertDeal(deal_num) ");
	
		sqlSession.delete(NAMESPACE+".deleteDeal", deal_num);
	}
	
	
}

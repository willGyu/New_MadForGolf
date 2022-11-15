package com.madforgolf.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.PayVO;

@Repository
public class PayDAOImpl implements PayDAO{

	private static final Logger log = LoggerFactory.getLogger(PayDAOImpl.class);
	
	
	//SqlSession객체(디비연결, mybatis, 매퍼, 자원해제)
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper 가상이름 정의
	private static final String NAMESPACE = "com.madforgolf.mapper.PayMapper";
	
	
	
	@Override
	public void payInsert(PayVO vo) {
		sqlSession.insert(NAMESPACE+".payInsert", vo);
	}

}

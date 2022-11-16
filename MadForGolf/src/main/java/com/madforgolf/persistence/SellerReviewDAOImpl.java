package com.madforgolf.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.ProductSellerVO;
import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.utils.PageMaker;

import sun.security.krb5.internal.PAEncTSEnc;

@Repository
public class SellerReviewDAOImpl implements SellerReviewDAO {

	private static final Logger log = LoggerFactory.getLogger(SellerReviewDAOImpl.class);


	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.madforgolf.mapper.SellerReviewMapper";

	
	@Override
	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSellerReview", prodNum);
	}


	@Override
	public List<SellerReviewVO> listSellerReviewAll(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSellerReviewAll", pageMaker);
	}


	@Override
	public int listSellerReviewAllTotalCount(PageMaker pageMaker) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSellerReviewAllTotalCount", pageMaker);
	}

	
	
	
	
	
}

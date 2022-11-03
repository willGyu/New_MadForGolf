package com.madforgolf.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

@Repository
public class HomeDAOImpl implements HomeDAO {

	private static final Logger log 
	    = LoggerFactory.getLogger(HomeDAOImpl.class);

	
	// SqlSession객체 주입(DI)
	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.madforgolf.mapper.HomeMapper";
	
	@Override
	public List<ProductVO> listMain(ProductVO vo) throws Exception {
		log.info("listMain()호출");
		
		List<ProductVO> productList;
		
		productList = sqlSession.selectList(NAMESPACE+".listMain",vo);
		
		return productList;
	}



}

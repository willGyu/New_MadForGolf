package com.madforgolf.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.ProductSellerVO;

@Repository
public class ProductSellerDAOImpl implements ProductSellerDAO {

	private static final Logger log = LoggerFactory.getLogger(ProductSellerDAOImpl.class);


	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.madforgolf.mapper.ProductSellerMapper";

	@Override
	public ProductSellerVO selectSellerInfo(ProductSellerVO productSellerVO) throws Exception {		
		return sqlSession.selectOne(NAMESPACE + ".selectSellerInfo", productSellerVO);
	}

	@Override
	public int sellerProductTotlaCount(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".sellerProductTotlaCount", map);
	}

	@Override
	public List<ProductSellerVO> sellerProductList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".sellerProductList", map);
	}
	
	
	
	
	
	
	
	
}

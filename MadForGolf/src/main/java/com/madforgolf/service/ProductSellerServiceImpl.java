package com.madforgolf.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.ProductSellerVO;
import com.madforgolf.persistence.MemberDAO;
import com.madforgolf.persistence.ProductSellerDAO;

@Service
public class ProductSellerServiceImpl implements ProductSellerService {


	private static final Logger log = LoggerFactory.getLogger(ProductSellerServiceImpl.class);


	@Autowired
	private ProductSellerDAO productSellerDAO;
	
	
	@Override
	public ProductSellerVO selectSellerInfo(ProductSellerVO productSellerVO) throws Exception {		
		return productSellerDAO.selectSellerInfo(productSellerVO);
	}


	@Override
	public int sellerProductTotlaCount(Map<String, Object> map) throws Exception {
		return productSellerDAO.sellerProductTotlaCount(map);
	}


	@Override
	public List<ProductSellerVO> sellerProductList(Map<String, Object> map) throws Exception {
		return productSellerDAO.sellerProductList(map);
	}
	

	
}

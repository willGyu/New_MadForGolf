package com.madforgolf.service;

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
	

}

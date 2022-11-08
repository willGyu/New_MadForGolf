package com.madforgolf.service;

import java.util.List;
import java.util.Map;

import com.madforgolf.domain.ProductSellerVO;

public interface ProductSellerService {

	public ProductSellerVO selectSellerInfo(ProductSellerVO productSellerVO)  throws Exception;

	public int sellerProductTotlaCount(Map<String, Object> map)  throws Exception;

	public List<ProductSellerVO> sellerProductList(Map<String, Object> map) throws Exception;
	
	
	
	

}

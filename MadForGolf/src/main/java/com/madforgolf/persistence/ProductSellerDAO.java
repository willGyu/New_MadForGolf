package com.madforgolf.persistence;

import java.util.List;
import java.util.Map;

import com.madforgolf.domain.ProductSellerVO;

public interface ProductSellerDAO {

	public ProductSellerVO selectSellerInfo(ProductSellerVO productSellerVO) throws Exception;

	
	public int sellerProductTotlaCount(Map<String, Object> map)  throws Exception;

	public List<ProductSellerVO> sellerProductList(Map<String, Object> map) throws Exception;
	
	
}

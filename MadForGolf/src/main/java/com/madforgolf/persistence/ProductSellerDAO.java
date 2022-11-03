package com.madforgolf.persistence;

import com.madforgolf.domain.ProductSellerVO;

public interface ProductSellerDAO {

	public ProductSellerVO selectSellerInfo(ProductSellerVO productSellerVO) throws Exception;

}

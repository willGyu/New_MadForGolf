package com.madforgolf.service;


import java.util.List;
import java.util.Map;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface HomeService {
	//메인(index.jsp)상품 목록 - 최신순(성별/카테고리 구분없음)
	public List<ProductVO> listMain(ProductVO vo) throws Exception;
	

}

package com.madforgolf.service;

import com.madforgolf.domain.DealVO;

public interface DealService {

	// 거래 생성
	public void insertDeal(DealVO vo) throws Exception;

	// 거래 수정(구매자 정보 삽입)
	public void updateDeal(Integer deal_num, String buyer_id) throws Exception;

	// 거래 수정 (거래 - 상품번호 삽입) 
	public void addProd_num(int prod_num) throws Exception;

	// 구매자 정보 삭제
	public void deleteBuyer(Integer deal_num) throws Exception;


}

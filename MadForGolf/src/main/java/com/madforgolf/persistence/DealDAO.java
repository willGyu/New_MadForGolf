package com.madforgolf.persistence;

import com.madforgolf.domain.DealVO;

public interface DealDAO {
	
	//거래 생성
	public void insertDeal(DealVO vo) throws Exception;
	
	//거래 정보 가져오기
	public DealVO getDeal(String buyer_id) throws Exception;

	//거래 취소하기(정보 삭제)
	public void deleteDeal(Integer deal_num) throws Exception;
}

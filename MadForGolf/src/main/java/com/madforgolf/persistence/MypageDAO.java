package com.madforgolf.persistence;

import java.util.List;

import com.madforgolf.domain.DealVO;
import com.madforgolf.domain.LikeListVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;

public interface MypageDAO {
	
	// 가계부
	// 월별 구매
	public int purchaseMonth(String user_id) throws Exception;
	
	// 월별 판매
	public int saleMonth(String user_id) throws Exception;
	
	// 월별 구매 횟수
	public int purchaseCnt(String user_id) throws Exception;

	// 월별 판매 횟수
	public int saleCnt(String user_id) throws Exception;

	// 드라이버 구매
	public int purchaseDriver(String user_id) throws Exception;

	// 아이언 구매
	public int purchaseIron(String user_id) throws Exception;
	
	// 유틸리티  구매
	public int purchaseUtil(String user_id) throws Exception;
	
	// 웨지 구매
	public int purchaseWedge(String user_id) throws Exception;
	
	// 퍼터 구매
	public int purchasePutter(String user_id) throws Exception;
	
	// 기타용품 구매
	public int purchaseEtc(String user_id) throws Exception;
	
	// 드라이버 판매
	public int saleDriver(String user_id) throws Exception;
	
	// 아이언 판매
	public int saleIron(String user_id) throws Exception;
	
	// 유틸리티  판매
	public int saleUtil(String user_id) throws Exception;
	
	// 웨지 판매
	public int saleWedge(String user_id) throws Exception;
	
	// 퍼터 판매
	public int salePutter(String user_id) throws Exception;
	
	// 기타용품 판매
	public int saleEtc(String user_id) throws Exception;
	
	//찜 목록
	public List<LikeListVO> likeList(PageMakerVO pm, String user_id) throws Exception;

	//찜 목록 글갯수
	public Integer likeListCnt(PageVO vo, String user_id) throws Exception;	
	
}

package com.madforgolf.persistence;

import java.util.List;

import com.madforgolf.domain.ChattingVO;

public interface ChattingDAO {
	// 채팅 등록 & chattingNum 가져오기
	public String chattingNumSelect(ChattingVO vo) throws Exception;
	
	// 채팅방 가져오기
	public ChattingVO chattingSelect(ChattingVO vo) throws Exception;
	
	// 채팅목록 가져오기
	public List<ChattingVO> chattingList(String talker1_id) throws Exception;
	
	// 채팅 총 개수 가져오기
	public Integer getTotalCnt(String talker1_id) throws Exception;
	
	// 채팅방 나가기
	public void chattingExit(ChattingVO vo) throws Exception;
}

package com.madforgolf.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.ChattingVO;
import com.madforgolf.persistence.ChattingDAO;

@Service
public class ChattingServiceImpl implements ChattingService {

	private static final Logger log = LoggerFactory.getLogger(ChattingServiceImpl.class);
	
	@Autowired
	ChattingDAO dao;
	
	// 채팅 등록 & chattingNum 가져오기
	@Override
	public String chattingNumSelect(ChattingVO vo) throws Exception {
		return dao.chattingNumSelect(vo);
		
	}
	
	// 채팅방 가져오기
	@Override
	public ChattingVO chattingSelect(ChattingVO vo) throws Exception {
		return dao.chattingSelect(vo);
	}
	
	// 채팅목록 가져오기
	@Override
	public List<ChattingVO> chattingList(String talker1_id) throws Exception {
		return dao.chattingList(talker1_id);
	}

	// 채팅 총 개수 가져오기(페이징 처리에 필요)
	@Override
	public Integer getTotalCnt(String talker1_id) throws Exception {
		return dao.getTotalCnt(talker1_id);
	}

	// 채팅방 나가기
	@Override
	public void chattingExit(ChattingVO vo) throws Exception {
		dao.chattingExit(vo);
	}
	
	
	
	
	
}

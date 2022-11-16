package com.madforgolf.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.ChattingVO;

@Repository
public class ChattingDAOImpl implements ChattingDAO {

	private static final Logger log = LoggerFactory.getLogger(ChattingDAOImpl.class);
	
	// SqlSession객체 주입(DI)
	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.madforgolf.mapper.ChattingMapper";
	
	// 채팅 등록 & 채팅방이 있다면 참가하기 & chattingNum 가져오기
	@Override
	public String chattingNumSelect(ChattingVO vo) throws Exception {
		String talker1_name = sqlSession.selectOne(NAMESPACE + ".selectName", vo.getTalker1_id());
		String talker2_name = sqlSession.selectOne(NAMESPACE + ".selectName", vo.getTalker2_id());
		
		vo.setTalker1_name(talker1_name);
		vo.setTalker2_name(talker2_name);
		
		ChattingVO chatting = sqlSession.selectOne(NAMESPACE + ".select", vo);
		String chattingNum = "";
		
		// 채팅방이 없을 때 => insert
		if(chatting == null) {
			sqlSession.insert(NAMESPACE + ".insert", vo);
			chatting = sqlSession.selectOne(NAMESPACE + ".select", vo);
			chattingNum = chatting.getChattingNum();
		} else {
			chattingNum = chatting.getChattingNum();
		}
		
		// 채팅방이 있지만 방을 나간 상태  => update
		if(chatting != null && chatting.getTalker1_id().equals("")) {
			if(!chatting.getTalker2_id().equals(vo.getTalker1_id())) {
				sqlSession.update(NAMESPACE + ".update1", vo); // vo.talker1로 update
			} else {
				sqlSession.update(NAMESPACE + ".update2", vo); // vo.talker2로 update
			}
		}
		if(chatting != null && chatting.getTalker2_id().equals("")) {
			if(!chatting.getTalker1_id().equals(vo.getTalker1_id())) {
				sqlSession.update(NAMESPACE + ".update3", vo); // vo.talker1로 update
			} else {
				sqlSession.update(NAMESPACE + ".update4", vo); // vo.talker2로 update
			}
		}
		
		return chattingNum;
	}

	// 채팅방 가져오기
	@Override
	public ChattingVO chattingSelect(ChattingVO vo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".select", vo);
	}

	// 채팅목록 가져오기
	@Override
	public List<ChattingVO> chattingList(String talker1_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectList", talker1_id);
	}

	// 채팅 총 개수 가져오기(페이징 처리에 필요)
	@Override
	public Integer getTotalCnt(String talker1_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectListNum", talker1_id);
	}

	// 채팅방 나가기
	@Override
	public void chattingExit(ChattingVO vo) throws Exception {
		ChattingVO chatting = sqlSession.selectOne(NAMESPACE + ".select", vo);
		
		// talker1 방 나가기
		if(chatting.getTalker1_id().equals(vo.getTalker1_id())) {			
			sqlSession.update(NAMESPACE + ".updateExit1", vo); // talker1 없애기
		}
		
		// talker2 방 나가기
		if(chatting.getTalker2_id().equals(vo.getTalker1_id())) {			
			sqlSession.update(NAMESPACE + ".updateExit2", vo); // talker2 없애기
		}
		
		// 채팅 참가자가 없을 때 => 채팅창 삭제 (delete)
		chatting = sqlSession.selectOne(NAMESPACE + ".select", vo);
		log.info("chatting : " + chatting);
		if(chatting != null && chatting.getTalker1_id().equals("") && chatting.getTalker2_id().equals("")) {
			sqlSession.delete(NAMESPACE + ".delete", vo);			
		}
		
		
	}
	
	
	
	
	
}

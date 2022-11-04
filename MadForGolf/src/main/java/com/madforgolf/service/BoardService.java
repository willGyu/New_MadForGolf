package com.madforgolf.service;

import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ReplyVO;


public interface BoardService {
	
	//글쓴이 이름 가져오기
	public String getUser_name(String user_id);
	
	//글쓰기
	public void boardWrite(BoardVO vo) throws Exception;
	//글내용 보기
	public BoardVO getBoard(Integer bno) throws Exception;
	//글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	//글 수정
	public Integer updateBoard(BoardVO vo) throws Exception;
	//글 삭제
	public Integer deleteBoard(Integer bno) throws Exception;
	//목록??
//	public List<BoardVO> listAll() throws Exception;
	

	//-----------------------------------------------------------------
	

	//글 전체 목록
//		public List<BoardVO> listBoardAll() throws Exception;

	//글 리스트 가져오기(페이징 처리)
	public List<BoardVO> listPage(PageVO vo) throws Exception;
	
	
	//글 리스트 가져오기(말머리)
	public List<BoardVO> listCategory(PageVO vo, String board_category) throws Exception;
	
	
	
	//-----------------------------------------------------------------
	
	
	
	// 댓글달기
	public void insertReply(ReplyVO vo) throws Exception;
	// 댓글출력
	public List<ReplyVO> getReply(Integer board_num, PageVO vo) throws Exception;
	// 댓글수정
	public Integer updateReply(ReplyVO vo) throws Exception;
	// 댓글삭제
	public Integer deleteReply(Integer reply_num) throws Exception;
	//댓글 수
	public Integer replyCnt(Integer board_num) throws Exception;
	
}
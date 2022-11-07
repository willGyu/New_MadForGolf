package com.madforgolf.persistence;


import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ReplyVO;

public interface BoardDAO {

	//글쓴이 이름 가져오기
	public String getUser_name(String user_id);
	
	//글쓰기 - boardWrite(vo)
	public void boardWrite(BoardVO vo) throws Exception;
	//글내용 보기
	public BoardVO getBoard(Integer bno) throws Exception;
	//글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	//글 수정
	public Integer updateBoard(BoardVO vo) throws Exception;
	//글 삭제
	public Integer deleteBoard(Integer bno) throws Exception;
	
	//------------------------------------------------------
	
	//목록??
//	public List<BoardVO> listAll() throws Exception;

	//글 전체 목록 - listBoardAll()
//	public List<BoardVO> listBoardAll() throws Exception;

	// 글 전체목록 - listPage(page) 
	public List<BoardVO> listPage(Integer page) throws Exception;
	
	// 글 전체 목록 - listPage(pageVO)
	public List<BoardVO> listPage(PageVO vo) throws Exception;
	
	// 글 전체 목록 - 인기순
	public List<BoardVO> listLikePage(PageVO vo);
	
	
	// 글 전체 목록 - listCategory(vo, board_category)
	public List<BoardVO> listCategory(PageVO vo, String board_category) throws Exception;
	
	//글 전체 목록 - 인기순(카테고리별)
	public List<BoardVO> listLikeCategory(PageVO vo, String board_category) throws Exception;


	//------------------------------------------------------
	
	
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


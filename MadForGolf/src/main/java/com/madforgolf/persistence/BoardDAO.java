package com.madforgolf.persistence;


import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;

public interface BoardDAO {
	
	//글내용 보기
	public BoardVO getBoard(Integer bno) throws Exception;
	//글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	//글 수정
	public Integer updateBoard(BoardVO vo) throws Exception;
	//글 삭제
	public Integer deleteBoard(Integer bno) throws Exception;
	//목록??
	public List<BoardVO> listAll() throws Exception;

	//글쓰기 - boardWrite(vo)
	public void boardWrite(BoardVO vo) throws Exception;

	//글 전체 목록 - listBoardAll()
	public List<BoardVO> listBoardAll() throws Exception;

	// 글 전체목록 - listPage(page) 
	public List<BoardVO> listPage(Integer page) throws Exception;
	
	// 글 전체 목록 - listPage(pageVO)
	public List<BoardVO> listPage(PageVO vo) throws Exception;
}

package com.madforgolf.service;

import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;


public interface BoardService {
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
	
	//글쓰기
	public void boardWrite(BoardVO vo) throws Exception;

	//글 전체 목록
	public List<BoardVO> listBoardAll() throws Exception;

	//글 리스트 가져오기(페이징 처리)
	public List<BoardVO> listPage(PageVO vo) throws Exception;
}
 
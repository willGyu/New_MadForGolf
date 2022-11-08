package com.madforgolf.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ReplyVO;
import com.madforgolf.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	//객체 생성
	//BoardDAO 객체 주입(DI)
	@Inject
	private BoardDAO dao;
	
	//글내용
	@Override
	public BoardVO getBoard(Integer board_num) throws Exception {
		return dao.getBoard(board_num);
	}
	 
	//조회수
	@Override
	public void updateReadCount(Integer board_num) throws Exception {
		dao.updateReadCount(board_num);
	}
	
	//수정
	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		return dao.updateBoard(vo);
	}
	
	//삭제
	@Override
	public Integer deleteBoard(Integer board_num) throws Exception {
		return dao.deleteBoard(board_num);
	}
	
	//목록
//	@Override
//	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
//		return null;
//	}
	
	//------------------------------------------------------------------------
	
	@Override
	public String getUser_name(String user_id) {
		log.info(" 2. service - getUser_name(user_id) ");

//		log.info("##############service user_name : "+dao.getUser_name(user_id));
		return dao.getUser_name(user_id);
	}
	
	
	//글작성
	@Override
	public void boardWrite(BoardVO vo) throws Exception {
		log.info(" 2. service - boardWrite(vo) ");
		
		dao.boardWrite(vo);
	}
	

	//------------------------------------------------------------------------
	
	
	
//	@Override
//	public List<BoardVO> listBoardAll() throws Exception {
//		log.info(" 2. service - getBoardListAll() ");
//		
//		List<BoardVO> boardList = dao.listBoardAll();
//		
//		return boardList;
//	}
	

	//------------------------------------------------------------------------
	
	
	//리스트(페이징 처리)
	@Override
	public List<BoardVO> listPage(PageVO vo) throws Exception {
		log.info(" 2. service - listPage(vo) ");
		
		return dao.listPage(vo);
	}
	
	
	//------------------------------------------------------------------------

	
	
	//리스트(페이징처리) - 인기순
	@Override
	public List<BoardVO> listLikePage(PageVO vo) {
		log.info(" 2. service - listLikePage(vo) ");
		return dao.listLikePage(vo);

	}


	//------------------------------------------------------------------------
	
	
	//리스트 - 카테고리별(페이징 처리)
	@Override
	public List<BoardVO> listCategory(PageVO vo, String board_category) throws Exception {
		
		log.info(" 2. service - listCategory(vo,board_category) ");
		
		
		
		return dao.listCategory(vo,board_category);
	}
	

	//------------------------------------------------------------------------
	
	
	
	//리스트 - 인기순, 카테고리별(페이징 처리)
	@Override
	public List<BoardVO> listLikeCategory(PageVO vo, String board_category) throws Exception {
		log.info(" 2. service - listLikeCategory(vo,board_category) ");
		return dao.listLikeCategory(vo,board_category);
	}
	
	
	//------------------------------------------------------------------------
	
	
	//댓글
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		dao.insertReply(vo);
	}

	@Override
	public List<ReplyVO> getReply(Integer board_num, PageVO vo) throws Exception {
		log.info("getReply(board_num, vo) 호출");
		return dao.getReply(board_num, vo);
	}

	@Override
	public Integer deleteReply(Integer reply_num) throws Exception {
		return dao.deleteReply(reply_num);
	}

	@Override
	public Integer updateReply(ReplyVO vo) throws Exception {
		return dao.updateReply(vo);
	}

	@Override
	public Integer replyCnt(Integer board_num) throws Exception {
		return dao.replyCnt(board_num);
	}

}



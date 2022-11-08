package com.madforgolf.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ReplyVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	
	
	//SqlSession객체(디비연결, mybatis, 매퍼, 자원해제)
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper 가상이름 정의
	private static final String NAMESPACE = "com.madforgolf.mapper.BoardMapper";
	
	 
	/////////////////////////////////////////////////////////////////////////////

	
	@Override
	public String getUser_name(String user_id) {
		log.info(" 3. DAO - getUser_name(user_id) ");
		
//		log.info("##############DAO user_id : "+user_id);
//		log.info("##############DAO user_name : "+NAMESPACE+".getUser_name",user_id);

		return sqlSession.selectOne(NAMESPACE+".getUser_name",user_id);
	}
	

	//----------------------------------------------------------------------
	
	
	
	
	//글쓰기
	@Override
	public void boardWrite(BoardVO vo) throws Exception{
		log.info(" 3. DAO - insertBoard(vo) ");
		
		int result = sqlSession.insert(NAMESPACE+".boardWrite", vo);
		
		if(result > 0) {
			log.info(" 4. DB - 글 삽입 완료 ");
		}
		
	}
	

	//----------------------------------------------------------------------
	
	
	
	
	//글내용
	@Override
	public BoardVO getBoard(Integer board_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getBoard", board_num);
	}
	
	//조회수
	@Override
	public void updateReadCount(Integer board_num) throws Exception {
		sqlSession.update(NAMESPACE+".updateReadCount", board_num);
	}
	
	//수정
	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		return sqlSession.update(NAMESPACE+".updateBoard", vo);
	}
	
	//삭제
	@Override
	public Integer deleteBoard(Integer board_num) throws Exception {
		return sqlSession.delete(NAMESPACE+".deleteBoard", board_num);
	}
	

	
	//----------------------------------------------------------------------

	
	
	//목록
//	@Override
//	public List<BoardVO> listAll() throws Exception {
//		return null;
//	}
	

//	@Override
//	public List<BoardVO> listBoardAll() throws Exception {
//		log.info(" 3. DAO - listBoardAll() " );
//		
//		List<BoardVO> boardListAll = sqlSession.selectList(NAMESPACE + ".listBoardAll");
//		
//		return boardListAll;
//	}
	
	
	//----------------------------------------------------------------------

	
	@Override
	public List<BoardVO> listPage(Integer page) throws Exception {
		log.info(" 3. DAO listPage(page) 호출 " );

		if(page <= 0) {
			page = 1;
			
		}
		
		int pageSize = 30;
		
		//1-0, 2-10, 3-20, 4-30,....
//		page = (page - 1)*10;
		page = (page - 1)*pageSize;
		
		
		Map<String, Object> pageObj = new HashMap<String, Object>();
		pageObj.put("page", page);
		pageObj.put("pageSize", pageSize);
		
		
		return sqlSession.selectList(NAMESPACE+".listPage2",pageObj);
	}
	
	

	

	//----------------------------------------------------------------------

	
	
	//PageVO 안에 페이징 처리 관련 정보들 담아오기
	@Override
	public List<BoardVO> listPage(PageVO vo) throws Exception {
		
		log.info(" 3. DAO - listPage(vo) 호출 ");
		
		
		return sqlSession.selectList(NAMESPACE+".listPage3",vo);
	}
	
	

	//----------------------------------------------------------------------

	
	@Override
	public List<BoardVO> listLikePage(PageVO vo) {
		log.info(" 3. DAO - listLikePage(vo) 호출 ");
		return sqlSession.selectList(NAMESPACE+".listLikePage",vo);
	}


	//----------------------------------------------------------------------

	
	@Override
	public List<BoardVO> listCategory(PageVO vo, String board_category) throws Exception {
		
		log.info(" 3. DAO - listCategory(vo, board_category) 호출 ");

		int page = vo.getPage();
		int perPageNum = vo.getPerPageNum();
		
		
		Map<String, Object> categoryObj = new HashMap<String, Object>();
		categoryObj.put("page", page);
		categoryObj.put("perPageNum", perPageNum);
		categoryObj.put("board_category", board_category);
		
//		log.info(categoryObj.toString());
		
		return sqlSession.selectList(NAMESPACE+".listCategory",categoryObj);
	}
	
	
	//----------------------------------------------------------------------
	
	
	@Override
	public List<BoardVO> listLikeCategory(PageVO vo, String board_category) throws Exception {
		
		log.info(" 3. DAO - listLikeCategory(vo, board_category) 호출 ");
		
		int page = vo.getPage();
		int perPageNum = vo.getPerPageNum();
		
		
		Map<String, Object> categoryObj = new HashMap<String, Object>();
		categoryObj.put("page", page);
		categoryObj.put("perPageNum", perPageNum);
		categoryObj.put("board_category", board_category);
		
//		log.info(categoryObj.toString());
		
		return sqlSession.selectList(NAMESPACE+".listLikeCategory",categoryObj);
	}
	
	
	

	//-------------------------------------------------------------------------
	
	
	
	
	//댓글
	@Override
	public void insertReply(ReplyVO vo) throws Exception {
		log.info("ReplyDAO 호출");
		sqlSession.insert(NAMESPACE+".insertReply", vo);
	}
	


	//-------------------------------------------------------------------------
	
	
	

	@Override
	public List<ReplyVO> getReply(Integer board_num, PageVO pageVO) throws Exception {
		//int page = vo.getPage();
		//int perPageNum = vo.getPerPageNum();
		log.info("getReply(board_num, vo) 호출");
		Map<String, Object> replyObj = new HashMap<String, Object>();
		replyObj.put("board_num", board_num);
		replyObj.put("pageVO", pageVO);
		//replyObj.put("page", page);
		//replyObj.put("perPageNum", perPageNum);
		log.info("getReply(board_num, vo) 성공");
		
		List<ReplyVO> list = sqlSession.selectList(NAMESPACE+".listReply", replyObj);
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + list);
		
		return list;
	}



	//-------------------------------------------------------------------------
	
	
	

	@Override
	public Integer deleteReply(Integer reply_num) throws Exception {
		return sqlSession.delete(NAMESPACE+".deleteReply", reply_num);
	}



	//-------------------------------------------------------------------------
	
	
	

	@Override
	public Integer updateReply(ReplyVO vo) throws Exception {
		return sqlSession.update(NAMESPACE+".updateReply", vo);
	}



	//-------------------------------------------------------------------------
	
	
	

	@Override
	public Integer replyCnt(Integer board_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".replyCnt", board_num);
	}
	
	
}

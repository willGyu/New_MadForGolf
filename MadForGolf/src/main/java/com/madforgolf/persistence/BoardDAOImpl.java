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

@Repository
public class BoardDAOImpl implements BoardDAO{
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	
	//SqlSession객체(디비연결, mybatis, 매퍼, 자원해제)
	@Inject
	private SqlSession sqlSession;
	
	//boardMapper 가상이름 정의
	private static final String NAMESPACE = "com.madforgolf.mapper.BoardMapper";
	
	 
	/////////////////////////////////////////////////////////////////////////////
	
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
	
	//목록
	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//----------------------------------------------------------------------
	
	
	
	@Override
	public void boardWrite(BoardVO vo) throws Exception{
		log.info(" 3. DAO - insertBoard(vo) ");
		
		int result = sqlSession.insert(NAMESPACE+".boardWrite", vo);
		
		if(result > 0) {
			log.info(" 4. DB - 글 삽입 완료 ");
		}
		
	}
	
	
	
	
	//----------------------------------------------------------------------

	
	@Override
	public List<BoardVO> listBoardAll() throws Exception {
		log.info(" 3. DAO - listBoardAll() " );
		
		List<BoardVO> boardListAll = sqlSession.selectList(NAMESPACE + ".listBoardAll");
		
		return boardListAll;
	}
	
	
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
}

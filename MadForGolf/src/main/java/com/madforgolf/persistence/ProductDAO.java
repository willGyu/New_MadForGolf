package com.madforgolf.persistence;

import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface ProductDAO {
	
	// 상품 전체 목록 - listAll() 
	public List<ProductVO> listAll(ProductVO vo) throws Exception;
	
	// 상품 등록 - insertProduct(vo)
	public void insertProduct(ProductVO vo) throws Exception;
	
	// 글 1개 정보 가져오기 - getBoard(int)
	public BoardVO getBoard(Integer bno) throws Exception;
	
	// 글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 글 수정하기
	public Integer updateBoard(BoardVO vo) throws Exception;
	
	// 글 삭제하기
	public Integer deleteBoard(Integer bno) throws Exception;
	
	// 글 전체목록 - listPage(page)
	public List<BoardVO> listPage(Integer page) throws Exception;
	
	// 글 전체목록 - listPage(pageVO)
	public List<ProductVO> listPage(PageVO vo) throws Exception;
	
}

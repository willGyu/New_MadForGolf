package com.madforgolf.service;


import java.util.List;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface ProductService {
	
	// 상품 전체 목록 불러오기
	public List<ProductVO> getProductListAll(ProductVO vo) throws Exception;
	
	// 상품 등록 (Insert)
	public void productInsert(ProductVO vo) throws Exception;
	
	// 글 1개정보 불러오기
	public BoardVO getBoard(Integer bno) throws Exception;
	
	// 글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 글 수정하기
	public Integer updateBoard(BoardVO vo) throws Exception;
	
	// 글 삭제하기
	public Integer deleteBoard(Integer bno) throws Exception;
	
	// 글 리스트 가져오기(페이징처리)
	public List<ProductVO> listPage(PageVO vo) throws Exception;
	
	

}

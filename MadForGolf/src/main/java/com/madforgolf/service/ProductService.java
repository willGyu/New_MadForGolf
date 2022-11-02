package com.madforgolf.service;


import java.util.List;
import java.util.Map;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface ProductService {
	
	// 상품 전체 목록 불러오기(최신순) (Read)
	public List<ProductVO> getProductListAll(ProductVO vo, PageVO vo2) throws Exception;
	
	// 상품 전체 목록 불러오기(인기순)
	public List<ProductVO> getProductListAll2(ProductVO vo, PageVO vo2) throws Exception;
	
	// 상품 1개 상세 불러오기
	public ProductVO productDetail(ProductVO vo) throws Exception;
	
	// 상품 전체 개수 불러오기
	public Integer getTotalCnt(ProductVO vo) throws Exception;
	
	// 상품 등록 (Insert)
	public void productInsert(ProductVO vo) throws Exception;
	
	// 상품정보 수정하기 (Update)
	public Integer updateProduct(ProductVO vo) throws Exception;
	
	
	
	
	// 상품수정 1개정보 불러오기
	public ProductVO getBoard(Integer prod_num) throws Exception;
	
	// 글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 글 삭제하기
	public Integer deleteBoard(Integer prod_num) throws Exception;
	
	// 글 리스트 가져오기(페이징처리)
	public List<ProductVO> listPage(PageVO vo) throws Exception;
	
	

}

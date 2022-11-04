package com.madforgolf.persistence;

import java.util.List;
import java.util.Map;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface ProductDAO {
	//메인(index.jsp)상품 목록 - 최신순(성별/카테고리 구분없음)
	public List<ProductVO> listMain(ProductVO vo) throws Exception;
	
	// 상품 전체 목록 - listAll() 최신순
	public List<ProductVO> listAll(ProductVO vo, PageVO vo2) throws Exception;
	
	// 상품 전체 목록 - listAll() 인기순
	public List<ProductVO> listAll2(ProductVO vo, PageVO vo2) throws Exception;
	
	// 상품 전체 개수 출력 - getTotalCnt()
	public Integer getTotalCnt(ProductVO vo) throws Exception;
	
	// 상품 1개 상세 출력 - getProductDetail(vo)
	public ProductVO getProductDetail(ProductVO vo) throws Exception;
	
	// 상품 등록 - insertProduct(vo)
	public void insertProduct(ProductVO vo) throws Exception;
	
	// 상품정보 수정하기 - update
	public Integer updateProduct(ProductVO vo) throws Exception;
	
	
	// 상품 수정 1개 정보 가져오기 - getBoard(int)
	public ProductVO getBoard (Integer prod_num) throws Exception;
	
	// 글 조회수 1증가
	public void updateReadCount(Integer bno) throws Exception;
	
	// 글 삭제하기
	public Integer deleteBoard(Integer prod_num) throws Exception;
	
	// 글 전체목록 - listPage(page)
	public List<BoardVO> listPage(Integer page) throws Exception;
	
	// 글 전체목록 - listPage(pageVO)
	public List<ProductVO> listPage(PageVO vo) throws Exception;

	
}

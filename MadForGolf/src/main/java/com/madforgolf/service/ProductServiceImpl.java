package com.madforgolf.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;
import com.madforgolf.persistence.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	// BoardDAO 객체 주입(DI)
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductVO> getProductListAll(ProductVO vo, PageVO vo2) throws Exception {
		log.info("getProductListAll() 호출");

		List<ProductVO> productList = dao.listAll(vo, vo2);

		return productList;
	}
	
	@Override
	public Integer getTotalCnt() throws Exception {
		return dao.getTotalCnt();
	}



	@Override
	public void productInsert(ProductVO vo) throws Exception {
		log.info("productInsert(vo) 호출");

		dao.insertProduct(vo);
	}

	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		log.info("getBoard(Integer bno) 호출 ");

		BoardVO vo = dao.getBoard(bno);

		return vo;
		//	return dao.getBoard(bno);
	}

	@Override
	public void updateReadCount(Integer bno) throws Exception {
		log.info("updateReadCount(bno) 호출");
		
		// DAO - updateReadCount(BNO)
		dao.updateReadCount(bno);
		
	}

	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		log.info(" updateBoard(vo) ");
		
		int cnt = dao.updateBoard(vo);
		
		return cnt;
	}

	@Override
	public Integer deleteBoard(Integer bno) throws Exception {
		log.info(" deleteBoard(bno) 호출 ");
		
		return dao.deleteBoard(bno);
	}

	@Override
	public List<ProductVO> listPage(PageVO vo) throws Exception {
		log.info(" listPage(PageVO vo) ");
		return dao.listPage(vo);
	}
	
	
	
	
	
	
	

}

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
import com.madforgolf.persistence.HomeDAO;
import com.madforgolf.persistence.ProductDAO;

@Service
public class HomeServiceImpl implements HomeService{

	private static final Logger log = LoggerFactory.getLogger(HomeServiceImpl.class);

	// BoardDAO 객체 주입(DI)
	@Autowired
	private HomeDAO dao;
	
	@Override
	public List<ProductVO> listMain(ProductVO vo) throws Exception {
		log.info("Service:listMain()호출");
		
		List<ProductVO> productList = dao.listMain(vo);
		
		return productList;
	}
	
	

}

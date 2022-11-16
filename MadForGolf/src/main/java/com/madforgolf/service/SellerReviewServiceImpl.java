package com.madforgolf.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.persistence.SellerReviewDAO;
import com.madforgolf.utils.PageMaker;

@Service
public class SellerReviewServiceImpl implements SellerReviewService {

	private static final Logger log = LoggerFactory.getLogger(SellerReviewServiceImpl.class);


	@Autowired
	private SellerReviewDAO sellerReviewDAO;
	
	
	@Override
	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception {
		return sellerReviewDAO.listSellerReview(prodNum);
	}


	@Override
	public List<SellerReviewVO> listSellerReviewAll(PageMaker pageMaker) throws Exception {
		return sellerReviewDAO.listSellerReviewAll(pageMaker);
	}


	@Override
	public int listSellerReviewAllTotalCount(PageMaker pageMaker) throws Exception {
		return sellerReviewDAO.listSellerReviewAllTotalCount(pageMaker);
	}

	
	

}

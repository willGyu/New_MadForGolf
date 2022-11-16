package com.madforgolf.service;

import java.util.List;

import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.utils.PageMaker;

public interface SellerReviewService {

	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception;

	public List<SellerReviewVO> listSellerReviewAll(PageMaker pageMaker) throws Exception;

	public int listSellerReviewAllTotalCount(PageMaker pageMaker) throws Exception;



}

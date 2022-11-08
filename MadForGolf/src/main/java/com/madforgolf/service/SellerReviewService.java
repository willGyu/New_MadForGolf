package com.madforgolf.service;

import java.util.List;

import com.madforgolf.domain.SellerReviewVO;

public interface SellerReviewService {

	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception;



}

package com.madforgolf.persistence;

import java.util.List;

import com.madforgolf.domain.SellerReviewVO;

public interface SellerReviewDAO {

	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception;


}

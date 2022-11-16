package com.madforgolf.persistence;

import java.util.List;

import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.utils.PageMaker;

public interface SellerReviewDAO {

	public List<SellerReviewVO> listSellerReview(Integer prodNum) throws Exception;


	public List<SellerReviewVO> listSellerReviewAll(PageMaker pageMaker) throws Exception;


	public int listSellerReviewAllTotalCount(PageMaker pageMaker) throws Exception;


}

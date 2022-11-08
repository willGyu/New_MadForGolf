package com.madforgolf.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.service.SellerReviewService;


@RequestMapping("/api/review")
@RestController
public class SellerReviewController {

	
	private static final Logger log = LoggerFactory.getLogger(SellerReviewController.class);


	@Autowired
	private SellerReviewService serllerReviewService;
	
	/**
	 * 리뷰 목록 불러오기
	 * http://localhost:8080/api/review/list/1
	 * @param prodNum
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list/{prodNum}")
	public ResponseEntity<?> listSellerReview(@PathVariable Integer prodNum ) throws Exception{
				
		List<SellerReviewVO> serList=serllerReviewService.listSellerReview(prodNum);
		log.info( "list   :  {}" , serList.size() );
		return ResponseEntity.status(HttpStatus.OK).body(serList);
	}
	
	
}

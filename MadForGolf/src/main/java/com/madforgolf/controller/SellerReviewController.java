package com.madforgolf.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.madforgolf.domain.SellerReviewVO;
import com.madforgolf.service.SellerReviewService;
import com.madforgolf.utils.PageMaker;

import lombok.extern.slf4j.Slf4j;


@RequestMapping("/api/review")
@RestController
@Slf4j
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
	
	/** 판매자에게 달린 모든 후기 가져오기
	 * http://localhost:8080/api/review/listall/76
	 * @param prodNum
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/listall/{prodNum}")
	public ResponseEntity<?> listSellerReviewAll(@PathVariable Integer prodNum , PageMaker pageMaker) throws Exception{
		log.info(" pageMaker   {}" , pageMaker.getPage());
		
		
		pageMaker.setProdNum(prodNum);
		pageMaker.setPerPageNum(5);		
		//전체 갯수 가져오기
		int totalCount=serllerReviewService.listSellerReviewAllTotalCount(pageMaker);
		pageMaker.setTotalCount(totalCount);					
		List<SellerReviewVO> serList=serllerReviewService.listSellerReviewAll(pageMaker);		
		
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		String pagination=pageMaker.bootStrapPagingSearchHTML("/api/review/listall/"+prodNum);
		
		map.put("code","success");
		map.put("totalCount", totalCount);
		map.put("pageMaker", pageMaker);
		map.put("serList", serList);
		map.put("pagination", pagination);
		
		
		log.info( "list   :  {}" , serList.size() );
		HttpHeaders responHeaders=new HttpHeaders();
		responHeaders.add("Content-Type", "text/html;charset=utf-8");
		
		return new ResponseEntity(new ObjectMapper().writeValueAsString(map), responHeaders, HttpStatus.OK);	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

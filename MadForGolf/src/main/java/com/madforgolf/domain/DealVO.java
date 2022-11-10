package com.madforgolf.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DealVO {
	
	private int deal_num; 
	
	private String seller_id;
	private MemberVO seller;
	
	private String buyer_id;
	private ProductVO buyer;

	private int prod_num;
	private ProductVO product;
	
	private int price;
	private String state;
	private Timestamp deal_date;
	
	
	
	
	
}

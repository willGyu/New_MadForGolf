package com.madforgolf.domain;

import java.sql.Timestamp;



public class SellerReviewVO  {
	private Integer review_num;
	private Integer prod_num;
	private String prod_name;
	private int price;
	private String content;
	private String review_img;
	private Integer score;
	private Timestamp review_date;
	private String seller_id;	
	private String buyer_id;
	private String buyer_name;
	private String prod_img;
	private int deal_num;			// 거래 번호
	
	public Integer getReview_num() {
		return review_num;
	}

	public void setReview_num(Integer review_num) {
		this.review_num = review_num;
	}

	public Integer getProd_num() {
		return prod_num;
	}

	public void setProd_num(Integer prod_num) {
		this.prod_num = prod_num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReview_img() {
		return review_img;
	}

	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Timestamp getReview_date() {
		return review_date;
	}

	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}

	
	
	
	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	
	

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	
	

	public int getDeal_num() {
		return deal_num;
	}

	public void setDeal_num(int deal_num) {
		this.deal_num = deal_num;
	}
	
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	@Override
	public String toString() {
		return "SellerReviewVO [review_num=" + review_num + ", prod_num=" + prod_num + ", prod_name=" + prod_name
				+ ", price=" + price + ", content=" + content + ", review_img=" + review_img + ", score=" + score
				+ ", review_date=" + review_date + ", seller_id=" + seller_id + ", buyer_id=" + buyer_id
				+ ", buyer_name=" + buyer_name + ", prod_img=" + prod_img + ", deal_num=" + deal_num + "]";
	}

	

	
	
}

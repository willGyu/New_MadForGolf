package com.madforgolf.domain;

import java.sql.Timestamp;

public class ReviewVO {
	
	private int review_num;
	private int prod_num;
	private String content;
	private String review_img;
	private int score;
	private Timestamp review_date;

	
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Timestamp getReview_date() {
		return review_date;
	}
	public void setReview_date(Timestamp review_date) {
		this.review_date = review_date;
	}
	
	
	@Override
	public String toString() {
		return "ReviewVO [review_num=" + review_num + ", prod_num=" + prod_num + ", content=" + content
				+ ", review_img=" + review_img + ", score=" + score + ", review_date=" + review_date + "]";
	}
	
	

}

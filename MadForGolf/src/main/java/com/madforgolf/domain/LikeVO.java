package com.madforgolf.domain;

public class LikeVO {

	private int prod_num;
	private String buyer_id;
	private int check;
	

	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "LikeVO [prod_num=" + prod_num + ", buyer_id=" + buyer_id + ", check=" + check + "]";
	}
	
	
	
}

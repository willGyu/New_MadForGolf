package com.madforgolf.domain;

public class LikeListVO {
	
	// 11/10 풀리퀘 전 추가해주세요
	
	private String seller_id;
	private String user_id;
	private String prod_name;
	private int price;
	private int check;
	private int prod_num;
	
	
	
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	@Override
	public String toString() {
		return "LikeListVO [user_id=" + user_id + ", prod_name=" + prod_name + ", price=" + price + ", check=" + check
				+ ", prod_num=" + prod_num + "]";
	}
	
	
	
}

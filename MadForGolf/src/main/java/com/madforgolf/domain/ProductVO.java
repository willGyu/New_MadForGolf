package com.madforgolf.domain;


public class ProductVO {
	private int prod_num;
	private String seller_id;
	private String prod_name;
	private String prod_img;
	private int price;
	private String detail;
	private String condition;
	private String category;
	private int gender;
	private int like_count;
	
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	
	@Override
	public String toString() {
		return "ProductVO [prod_num=" + prod_num + ", seller_id=" + seller_id + ", prod_name=" + prod_name
				+ ", prod_img=" + prod_img + ", price=" + price + ", detail=" + detail + ", condition=" + condition
				+ ", category=" + category + ", gender=" + gender + ", like_count=" + like_count + "]";
	}
	
	
}

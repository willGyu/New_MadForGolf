package com.madforgolf.domain;

import java.sql.Date;

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
	private Date prod_date;
	private String prod_img2;
	private String prod_img3;
	
	//거래 상태 추가 함 
	private int dealState;
	
	public int getDealState() {
		return dealState;
	}
	public void setDealState(int dealState) {
		this.dealState = dealState;
	}
	//거래 상태 추가 함 
	
	//상품상세 페이지에서 거래전/후 버튼 테스트한다고 user_id만듦~~(나중에 마이페이지에서 버튼 만들면 MemberVO user_id쓰면 될듯..
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}	
	//상품상세 페이지에서 거래전/후 버튼 테스트한다고 user_id만듦~~
	
	
	public int getProduct_num() {
		return prod_num;
	}
	public void setProduct_num(int prod_num) {
		this.prod_num = prod_num;
	}
	
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
	public Date getProd_date() {
		return prod_date;
	}
	public void setProd_date(Date prod_date) {
		this.prod_date = prod_date;
	}
	public String getProd_img2() {
		return prod_img2;
	}
	public void setProd_img2(String prod_img2) {
		this.prod_img2 = prod_img2;
	}
	public String getProd_img3() {
		return prod_img3;
	}
	public void setProd_img3(String prod_img3) {
		this.prod_img3 = prod_img3;
	}
	/* 
	 * @Override public String toString() { return "ProductVO [prod_num=" + prod_num
	 * + ", seller_id=" + seller_id + ", prod_name=" + prod_name + ", prod_img=" +
	 * prod_img + ", price=" + price + ", detail=" + detail + ", condition=" +
	 * condition + ", category=" + category + ", gender=" + gender + ", like_count="
	 * + like_count + ", prod_date=" + prod_date + ", prod_img2=" + prod_img2 +
	 * ", prod_img3=" + prod_img3 + "]"; }
	 */
	//dealState,user_id 추가로 toString 재정의 
	@Override
	public String toString() {
		return "ProductVO [prod_num=" + prod_num + ", seller_id=" + seller_id + ", prod_name=" + prod_name
				+ ", prod_img=" + prod_img + ", price=" + price + ", detail=" + detail + ", condition=" + condition
				+ ", category=" + category + ", gender=" + gender + ", like_count=" + like_count + ", prod_date="
				+ prod_date + ", prod_img2=" + prod_img2 + ", prod_img3=" + prod_img3 + ", dealState=" + dealState
				+ ", user_id=" + user_id + ", getDealState()=" + getDealState() + ", getUser_id()=" + getUser_id()
				+ ", getProduct_num()=" + getProduct_num() + ", getProd_num()=" + getProd_num() + ", getSeller_id()="
				+ getSeller_id() + ", getProd_name()=" + getProd_name() + ", getProd_img()=" + getProd_img()
				+ ", getPrice()=" + getPrice() + ", getDetail()=" + getDetail() + ", getCondition()=" + getCondition()
				+ ", getCategory()=" + getCategory() + ", getGender()=" + getGender() + ", getLike_count()="
				+ getLike_count() + ", getProd_date()=" + getProd_date() + ", getProd_img2()=" + getProd_img2()
				+ ", getProd_img3()=" + getProd_img3() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	

	
}

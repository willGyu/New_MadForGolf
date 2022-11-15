package com.madforgolf.domain;

import lombok.Data;

@Data
public class PayVO {
	private int pay_num;
	private int prod_num;
	private int price;
	private String payment;
	
	
	
	public int getPay_num() {
		return pay_num;
	}
	public void setPay_num(int pay_num) {
		this.pay_num = pay_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "PayVO [pay_num=" + pay_num + ", prod_num=" + prod_num + ", price=" + price + ", payment=" + payment
				+ "]";
	}

	
	
	
	
}

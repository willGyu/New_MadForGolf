package com.madforgolf.domain;

import lombok.Data;

@Data
public class PayResultVO {
	private String req_account_num_masked;
	private String req_bank_name;
	private String req_account_holder_name;
	private String recv_account_alias;
	private String recv_bank_name;
	private String recv_account_holder_name;
	private String recv_tran_amt;
	public String getReq_account_num_masked() {
		return req_account_num_masked;
	}
	public void setReq_account_num_masked(String req_account_num_masked) {
		this.req_account_num_masked = req_account_num_masked;
	}
	public String getReq_bank_name() {
		return req_bank_name;
	}
	public void setReq_bank_name(String req_bank_name) {
		this.req_bank_name = req_bank_name;
	}
	public String getReq_account_holder_name() {
		return req_account_holder_name;
	}
	public void setReq_account_holder_name(String req_account_holder_name) {
		this.req_account_holder_name = req_account_holder_name;
	}
	public String getRecv_account_alias() {
		return recv_account_alias;
	}
	public void setRecv_account_alias(String recv_account_alias) {
		this.recv_account_alias = recv_account_alias;
	}
	public String getRecv_bank_name() {
		return recv_bank_name;
	}
	public void setRecv_bank_name(String recv_bank_name) {
		this.recv_bank_name = recv_bank_name;
	}
	public String getRecv_account_holder_name() {
		return recv_account_holder_name;
	}
	public void setRecv_account_holder_name(String recv_account_holder_name) {
		this.recv_account_holder_name = recv_account_holder_name;
	}
	public String getRecv_tran_amt() {
		return recv_tran_amt;
	}
	public void setRecv_tran_amt(String recv_tran_amt) {
		this.recv_tran_amt = recv_tran_amt;
	}
	@Override
	public String toString() {
		return "PayResultVO [req_account_num_masked=" + req_account_num_masked + ", req_bank_name=" + req_bank_name
				+ ", req_account_holder_name=" + req_account_holder_name + ", recv_account_alias=" + recv_account_alias
				+ ", recv_bank_name=" + recv_bank_name + ", recv_account_holder_name=" + recv_account_holder_name
				+ ", recv_tran_amt=" + recv_tran_amt + "]";
	}
	
	
}

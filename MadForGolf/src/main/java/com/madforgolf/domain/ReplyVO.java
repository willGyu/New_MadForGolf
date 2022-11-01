package com.madforgolf.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private Integer reply_num;
	private Integer board_num;
	private String user_id;
	private String user_name;
	private String reply_content;
	private Timestamp reply_date;
	private Timestamp reply_updatedate;
	public Integer getReply_num() {
		return reply_num;
	}
	public void setReply_num(Integer reply_num) {
		this.reply_num = reply_num;
	}
	public Integer getBoard_num() {
		return board_num;
	}
	public void setBoard_num(Integer board_num) {
		this.board_num = board_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Timestamp getReply_date() {
		return reply_date;
	}
	public void setReply_date(Timestamp reply_date) {
		this.reply_date = reply_date;
	}
	public Timestamp getReply_updatedate() {
		return reply_updatedate;
	}
	public void setReply_updatedate(Timestamp reply_updatedate) {
		this.reply_updatedate = reply_updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_num=" + reply_num + ", board_num=" + board_num + ", user_id=" + user_id + ", user_name="
				+ user_name + ", reply_content=" + reply_content + ", reply_date=" + reply_date + ", reply_updatedate="
				+ reply_updatedate + "]";
	}
	
	
}

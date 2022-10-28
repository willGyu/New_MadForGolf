package com.madforgolf.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	private String board_num;
	private String board_category;
	private String user_id;
	private String user_name;
	
	private String title;
	private String content;
	private String content_img;
	private String content_real_img;
	private String content_file;
	private String content_real_file;
	private Timestamp write_date;
	private int re_reference;
	private int re_sequence;
	private int readcount;
	public String getBoard_num() {
		return board_num;
	}
	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent_img() {
		return content_img;
	}
	public void setContent_img(String content_img) {
		this.content_img = content_img;
	}
	public String getContent_real_img() {
		return content_real_img;
	}
	public void setContent_real_img(String content_real_img) {
		this.content_real_img = content_real_img;
	}
	public String getContent_file() {
		return content_file;
	}
	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}
	public String getContent_real_file() {
		return content_real_file;
	}
	public void setContent_real_file(String content_real_file) {
		this.content_real_file = content_real_file;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getRe_reference() {
		return re_reference;
	}
	public void setRe_reference(int re_reference) {
		this.re_reference = re_reference;
	}
	public int getRe_sequence() {
		return re_sequence;
	}
	public void setRe_sequence(int re_sequence) {
		this.re_sequence = re_sequence;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", board_category=" + board_category + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", title=" + title + ", content=" + content + ", content_img="
				+ content_img + ", content_real_img=" + content_real_img + ", content_file=" + content_file
				+ ", content_real_file=" + content_real_file + ", write_date=" + write_date + ", re_reference="
				+ re_reference + ", re_sequence=" + re_sequence + ", readcount=" + readcount + "]";
	} 

	
	
}

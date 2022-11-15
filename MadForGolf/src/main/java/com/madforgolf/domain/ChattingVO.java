package com.madforgolf.domain;

public class ChattingVO {
	private String chattingNum;
	private String talker1_id;
	private String talker1_name;
	private String talker2_id;
	private String talker2_name;

	public String getChattingNum() {
		return chattingNum;
	}

	public void setChattingNum(String chattingNum) {
		this.chattingNum = chattingNum;
	}

	public String getTalker1_id() {
		return talker1_id;
	}

	public void setTalker1_id(String talker1_id) {
		this.talker1_id = talker1_id;
	}

	public String getTalker1_name() {
		return talker1_name;
	}

	public void setTalker1_name(String talker1_name) {
		this.talker1_name = talker1_name;
	}

	public String getTalker2_id() {
		return talker2_id;
	}

	public void setTalker2_id(String talker2_id) {
		this.talker2_id = talker2_id;
	}

	public String getTalker2_name() {
		return talker2_name;
	}

	public void setTalker2_name(String talker2_name) {
		this.talker2_name = talker2_name;
	}

	@Override
	public String toString() {
		return "ChattingVO [chattingNum=" + chattingNum + ", talker1_id=" + talker1_id + ", talker1_name="
				+ talker1_name + ", talker2_id=" + talker2_id + ", talker2_name=" + talker2_name + "]";
	}
	
	
}

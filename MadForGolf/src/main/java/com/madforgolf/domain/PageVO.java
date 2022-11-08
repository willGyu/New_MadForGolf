package com.madforgolf.domain;

import javax.servlet.http.HttpSession;

// 페이징 처리에 필요한 정보를 관리하는 객체
public class PageVO {
	private int page;		// 페이지
	private int perPageNum; // 페이지 크기
	
	HttpSession session;
	
	//seller_id
	private String seller_id;
	
	
	public String getSeller_id() {
		return seller_id;
	}
	
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	//seller_id

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}


	public PageVO() {
		// 페이징 처리의 정보가 없을 때(기본값)
		this.page = 1;
		this.perPageNum = 6;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		// 0보다 작은 페이지 정보 호출
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		// 한번에 보여줄 글의 수
		if(perPageNum < 6 || perPageNum > 100) {
			this.perPageNum = 6;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	// mapper의 #{pageStart} 요소를 위한 메서드
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", perPageNum=" + perPageNum + ", session=" + session + ", seller_id="
				+ seller_id + "]";
	}


	
	/*
	 * @Override public String toString() { return "PageVO [page=" + page +
	 * ", perPageNum=" + perPageNum + "]"; }
	 */
	
	
	
	
	
	
}

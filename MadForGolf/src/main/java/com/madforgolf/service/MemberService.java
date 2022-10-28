package com.madforgolf.service;


import com.madforgolf.domain.MemberVO;

public interface MemberService {


	//회원 가입 처리
	public void insert(MemberVO vo) throws Exception;
	
	//아이디 중복체크
	public int idCheck(MemberVO vo) throws Exception;
	
	// 로그인 
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 로그인2 
	public MemberVO login(String user_id,String user_pw) throws Exception;
	
	// 회원 정보 가져오기
	public MemberVO getMember(String id);
	
	public Integer updateMember(MemberVO uvo);
	
	public MemberVO loginMember(MemberVO vo);
	
	public MemberVO loginMember(String userid, String userpw);
	
		
	
	
		
}

	

package com.madforgolf.persistence;


import java.util.List;

import com.madforgolf.domain.MemberVO;

public interface MemberDAO {



		//회원가입 처리
		public void insert(MemberVO vo) throws Exception;
	
		//아이디 중복 체크 
		public int idCheck(MemberVO vo) throws Exception;
		
		//휴대번호 중복 체크   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    1029 서하 추가
		public int phoneCheck(MemberVO vo) throws Exception;
		
		// 로그인 동작
		public MemberVO login(MemberVO vo) throws Exception;
		
		// 로그인 동작2 (메서드 오버로딩)
		public MemberVO login(String user_id, String user_pw) throws Exception;
		
		
		// 아이디 찾기
		public MemberVO findId(MemberVO vo) throws Exception;
		
		// 비밀번호 찾기
//		public MemberVO findPw(MemberVO vo) throws Exception;
		
		// 비밀번호 변경
		public MemberVO updatePw(MemberVO vo) throws Exception;
		
		
		// 회원정보 조회
		public MemberVO getMember(String id);
		
		// 회원정보 수정
		public Integer updateMember(MemberVO uvo);
		
		// 회원 탈퇴
		public void deleteMember(MemberVO dvo) throws Exception;
		
		// 회원목록 리스트 조회
		public List<MemberVO> getMemberList();

		
		public MemberVO loginMember(MemberVO vo);
		
	
}





package com.madforgolf.persistence;


import java.util.HashMap;
import java.util.List;

import com.madforgolf.domain.LikeListVO;
import com.madforgolf.domain.LikeVO;
import com.madforgolf.domain.MemberVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;

public interface MemberDAO {



		//회원가입 처리
		public void insert(MemberVO vo) throws Exception;
	
		//아이디 중복 체크 
		public int idCheck(MemberVO vo) throws Exception;
		
		//휴대번호 중복 체크
		public int phoneCheck(MemberVO vo) throws Exception;
		
		// 로그인 동작
		public MemberVO login(MemberVO vo) throws Exception;
		
		// 로그인 동작2 (메서드 오버로딩)
		public MemberVO login(String user_id, String user_pw) throws Exception;
		
		
		// 아이디 찾기
		public MemberVO findId(MemberVO vo) throws Exception;
		
		// 비밀번호 찾기
		public MemberVO findPw(MemberVO vo) throws Exception;
		
		// 비밀번호 변경
		public MemberVO updatePw(MemberVO vo) throws Exception;
		
		
		// 회원정보 조회
		public MemberVO getMember(String id);
						
		// 회원정보 수정
		public Integer updateMember(MemberVO uvo);
				
		// 수정 휴대번호 중복 체크
		public int updatePhoneCheck(MemberVO vo) throws Exception;
		
		
		// 회원 탈퇴
		public void deleteMember(MemberVO dvo) throws Exception;
		
		// 비밀번호 체크
		public int pwCheck(MemberVO vo) throws Exception;
		
		// 회원목록 리스트 조회
		public List<MemberVO> getMemberList();
				
		// 로그인 정보 받아오기 (회원정보수정)
		public MemberVO loginMember(MemberVO vo);

				
		//전화번호 업데이트 처리
		public int updatePhone(MemberVO vo) throws Exception;
		
		
		// 카카오 로그인
		public void kakaoinsert(HashMap<String, Object> userInfo) throws Exception;
		
		public MemberVO findkakao(HashMap<String, Object> userInfo) throws Exception;
		
		// ▼ 11/10 풀리퀘 전 추가해주세요
		
				//위도 경도 저장
				public void lalong(HashMap<String, String> paramMap);
				
				
				// 역지오코딩 주소 저장 
				public int saveAddr(MemberVO vo) throws Exception;
								
				// SNS - 위도 경도 저장 
				public void lalongAddr(HashMap<String, String> paramMap);
				
				// ▲ 11/10 풀리퀘 전 추가해주세요
		
	
		
				
				
}





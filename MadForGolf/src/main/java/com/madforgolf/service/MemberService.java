package com.madforgolf.service;


import java.util.HashMap;
import java.util.List;

import com.madforgolf.domain.DealVO;
import com.madforgolf.domain.LikeListVO;
import com.madforgolf.domain.LikeVO;
import com.madforgolf.domain.MemberVO;

public interface MemberService {


	//회원 가입 처리
	public void insert(MemberVO vo) throws Exception;
	
	//아이디 중복체크
	public int idCheck(MemberVO vo) throws Exception;
	
	
	//휴대번호 중복체크
	public int phoneCheck(MemberVO vo) throws Exception;
	
	// 로그인 
	public MemberVO login(MemberVO vo) throws Exception;
	
	// 로그인2 
	public MemberVO login(String user_id,String user_pw) throws Exception;
	
	// 회원정보 조회
	public MemberVO getMember(String id);
				
	// 회원정보 수정
	public Integer updateMember(MemberVO uvo);
		
	//휴대번호 중복체크
	public int updatePhoneCheck(MemberVO vo) throws Exception;
		
	// 로그인 정보 받아오기 (회원정보수정)
	public MemberVO loginMember(MemberVO vo);
	
	//전화 번호 업데이트 처리
	public int updatePhone(MemberVO vo) throws Exception;
	
	// 아이디 찾기
	public MemberVO findId(MemberVO vo) throws Exception;
	
	// 비밀번호 찾기
	public MemberVO findPw(MemberVO vo) throws Exception;
	
	// 비밀번호 수정
	public MemberVO updatePw(MemberVO vo) throws Exception;
	
	// 회원 탈퇴
	public void deleteMember(MemberVO vo) throws Exception;
	
	// 비밀번호 체크
	public int pwCheck(MemberVO vo) throws Exception;
	
	//카카오 로그인
	public String getAccessToken(String autorize_code) throws Exception;
			
	//카카오 사용자 정보 요청
	public MemberVO getUserInfo(String access_Token) throws Exception;
	
	
	//위도 경도
		public void lalong(HashMap<String, String> paramMap);

		//카카오 지도
		public String getKakaoApiFromAddress(String roadFullAddr);

		//JSON String -> Map
		public HashMap<String, String> getXYMapfromJson(String jsonString);
		
		// 역지오코딩 주소 저장 
		public int saveAddr(MemberVO vo) throws Exception;
				
		// SNS - 위도 경도 저장  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		public void lalongAddr(HashMap<String, String> paramMap);
		
		// 찜목록 
		public List<LikeListVO> getLikeList(LikeListVO vo3) throws Exception;
			
		// 찜한 상품 개수 가져오기
		public Integer getTotalCnt(LikeVO vo) throws Exception;
		
}

	

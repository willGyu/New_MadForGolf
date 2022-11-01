package com.madforgolf.service;


import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.MemberVO;
import com.madforgolf.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	private static final Logger log
			= LoggerFactory.getLogger(MemberServiceImpl.class);


	private final MemberDAO dao;

	@Inject
	public MemberServiceImpl(MemberDAO dao) {
		this.dao= dao;
	}
	
	//회원 가입
	@Override
	public void insert(MemberVO vo) throws Exception {
		log.info("MemberServiceImpl - insert() 호출");
		dao.insert(vo);
		log.info("DAO 동작 완료! 서비스 -> 컨트롤러");

	}
	//아이디 중복 체크
	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return dao.idCheck(vo);
	}
	
	//휴대번호 중복 체크  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    1029 서하 추가
	@Override
	public int phoneCheck(MemberVO vo) throws Exception {
		return dao.phoneCheck(vo);
	}
	
	
	
	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {

	log.info("MemberServiceImpl - login(MemberVO vo)  호출");
	
	return dao.login(vo);
	}

	// 로그인 2
	@Override
	public MemberVO login(String user_id, String user_pw) throws Exception {
		return null;
	}
	
	
	
	
	
	
	@Override
	public MemberVO getMember(String id) {
		//메서드 호출
		return dao.getMember(id);
	}
//	
//	@Override
//	public Integer updateMember(MemberVO uvo) {
//		//메서드 호출
//		return dao.updateMember(uvo);
//	}
//
//	@Override
//	public MemberVO loginMember(MemberVO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public MemberVO loginMember(String userid, String userpw) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	
	
	
	
	
	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		log.info("findId(MemberVO vo) 호출");
		
		return dao.findId(vo);
	}
	
	// 비밀번호 찾기
//	@Override
//	public MemberVO findPw(MemberVO vo) throws Exception {
//		log.info("findPw(MemberVO vo) 호출");
//		
//		return dao.findPw(vo);
//	}
	
	// 비밀번호 변경
	@Override
	public MemberVO updatePw(MemberVO vo) throws Exception {
		log.info("updatePw(MemberVO vo)");
		
		log.info(" serviceImpl @@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+vo);
		return dao.updatePw(vo);
	}


	// 회원 탈퇴
//	@Override
//	public void deleteMember(String user_id) throws Exception {
//		log.info("deleteMember(MemberVO dvo) 호출");
//		
//		log.info("@@@@@@@@@@@ serviceImpl"+user_id);
//		
//		return dao.deleteMember(user_id);
//	}
}

	

	



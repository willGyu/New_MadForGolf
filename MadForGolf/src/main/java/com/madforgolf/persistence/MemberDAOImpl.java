package com.madforgolf.persistence;



import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import com.madforgolf.domain.MemberVO;

import com.mysql.cj.log.Log;

	
@Repository
public class MemberDAOImpl implements MemberDAO {

	
	private static final Logger log = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
	private static final String NAMESPACE = "com.madforgolf.mapper.MemberMapper";
	
	private final SqlSession sqlSession;
	
	
	@Inject
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	} 

	
	// 회원가입 처리
	@Override
	public void insert(MemberVO vo) throws Exception {
		sqlSession.insert(NAMESPACE+".insert", vo);
	}

	// 아이디 중복 체크
	@Override
	public int idCheck(MemberVO vo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".idCheck", vo);
	}
	
	
	//휴대번호 중복 체크  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    1029 서하 추가
	@Override
	public int phoneCheck(MemberVO vo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".phoneCheck", vo);	
	}
	
	
	
	

	// 로그인
		@Override
		public MemberVO login(MemberVO vo) throws Exception {
			log.info("login(vo) 호출"); 
			
			MemberVO resultVO 
			   = sqlSession.selectOne(NAMESPACE+".login",vo);
			
			// mapper에서 쿼리 실행 결과 저장해서 리턴
			
			return resultVO;
		}



		@Override
		public MemberVO login(String user_id, String user_pw) throws Exception {
			log.info("login(userid,userpw) 호출");
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			//paramMap.put("컬럼명", 데이터값);
			
			paramMap.put("userid", user_id);
			paramMap.put("userpw", user_pw);
			
			MemberVO vo = sqlSession.selectOne(NAMESPACE+".login",paramMap);
			log.info(vo + "");
			
			return vo;
				
		}
		
		
		@Override
		public MemberVO getMember(String id) {

			log.info(" getMember(String id) 호출 ");
			log.info(" mapper-sql 구문 호출 동작 ");
			
			String userid=id;
						
			MemberVO resultVO 
			   = sqlSession.selectOne(NAMESPACE+".getMember", userid);
			
			log.info(resultVO+"");
						   
			return resultVO;
		}

		@Override
		public Integer updateMember(MemberVO uvo) {
			
			log.info(" 테스트 -> updateMember(MemberVO uvo) 호출 ");
			
			int result = sqlSession.update(NAMESPACE+".updateMember",uvo);
			
			log.info(" 회원 정보 수정 완료 ");
			// result => 0 (수정x),1 (수정o)
			log.info("@@@@@@@@@@"+ result+"");
			log.info(" updateMember -> 테스트 호출 ");
			
			return result;
		}
	
	
		@Override
		public MemberVO loginMember(MemberVO vo) {
			
			return sqlSession.selectOne(NAMESPACE+".login", vo);
		}
		
		
	

	// 은주 시작
	
	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".findId", vo);
	}
	
	// 비밀번호 찾기
//	@Override
//	public MemberVO findPw(MemberVO vo) throws Exception {
//		log.info("dao 호출");
//		
//		return sqlSession.selectOne(NAMESPACE+".findPw", vo);
//	}
	
	// 비밀번호 변경
	@Override
	public MemberVO updatePw(MemberVO vo) throws Exception {
		log.info("비밀번호 변경 dao 호출");
		
		log.info("dao에서 테스트"+vo);
		
		log.info(sqlSession.selectOne(NAMESPACE+".updatePw", vo));
		return sqlSession.selectOne(NAMESPACE+".updatePw", vo);
	}


	


	// 회원 탈퇴	
	@Override
	public void deleteMember(MemberVO dvo) throws Exception {
		// mapper - sql 호출
		log.info("회원탈퇴 dao 호출");
		
		log.info("dao에서 테스트"+dvo);
		
		sqlSession.delete(NAMESPACE+".deleteMember", dvo);
	}

	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}




	

}
		


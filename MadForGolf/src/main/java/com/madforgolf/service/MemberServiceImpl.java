package com.madforgolf.service;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
	
	//휴대번호 중복 체크
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
	
	
	// 회원정보 수정
	@Override
	public Integer updateMember(MemberVO uvo) {
		//메서드 호출
		return dao.updateMember(uvo);
	}

	
	// 로그인 정보 받아오기 (회원정보수정)
	@Override
	public MemberVO loginMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.loginMember(vo);
	}
	
	
	
	
	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		log.info("findId(MemberVO vo) 호출");
		
		return dao.findId(vo);
	}
	
	// 비밀번호 찾기
	@Override
	public MemberVO findPw(MemberVO vo) throws Exception {
		log.info("findPw(MemberVO vo) 호출");
		
		return dao.findPw(vo);
	}
	
	// 비밀번호 변경
	@Override
	public MemberVO updatePw(MemberVO vo) throws Exception {
		log.info("updatePw(MemberVO vo)");
		
		log.info(" serviceImpl @@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+vo);
		return dao.updatePw(vo);
	}


	// 회원 탈퇴
	@Override
	public void deleteMember(MemberVO dvo) throws Exception {
		log.info("deleteMember(MemberVO dvo) 호출");
		
		log.info("@@@@@@@@@@@ serviceImpl"+dvo);
		
		dao.deleteMember(dvo);
	}
	
	// 비밀번호 체크
	@Override
	public int pwCheck(MemberVO vo) throws Exception {
		int result = dao.pwCheck(vo);
		
		return result;
	}
	
	
	//카카오톡 사용자 정보 요청
	@Override
	public MemberVO getUserInfo(String access_Token) throws Exception {

		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);
			
			// 키값, 속성 적용
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String result = "";

			while ((line = buffer.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			
//			log.info("@@@@@@@ kakaoAccount : "+kakao_account);
			String user_name = properties.getAsJsonObject().get("nickname").getAsString();
			String user_id = kakao_account.getAsJsonObject().get("email").getAsString();
			
			
			log.info("@@@@@@@@@@ user_id : "+user_name);
			log.info("@@@@@@@@@@ user_id : "+user_id);
			
			userInfo.put("user_name", user_name);
			userInfo.put("user_id", user_id);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		// DB에 저장되어있는지 확인하기
		MemberVO result = dao.findkakao(userInfo);
		log.info("DB 저장 확인 : "+result);
		
		if(result == null) {
			// 정보 저장 x
			// 저장하기 위해 repository로 이동
			dao.kakaoinsert(userInfo);
			
			// 정보 저장 후 컨트롤러로 정보 보내기
			return dao.findkakao(userInfo);
			
		}else {
			return result;
		}
		
	}

	//카카오로그인
	@Override
	public String getAccessToken(String authorize_code) throws Exception {
		
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
            
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
            
			sb.append("&client_id=a1e9c36223914cdc6e0edf2ff5f92f81"); //본인이 발급받은 key
			sb.append("&redirect_uri=http://localhost:8088/member/kakaoLogin"); // 본인이 설정한 주소
            
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();
            
			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			log.info("responseCode : " + responseCode);
            
			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";
            
			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
            
			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
            
			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            
			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);
            
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}
	
	
}




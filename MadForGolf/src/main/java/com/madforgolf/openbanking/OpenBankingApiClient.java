package com.madforgolf.openbanking;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.madforgolf.openbanking.domain.RequestTokenVO;
import com.madforgolf.openbanking.domain.ResponseTokenVO;

@Service
public class OpenBankingApiClient {
	
	private String client_id="1a6ed02d-91ea-452a-8c74-b6b4222ccd0e";
	private String client_secret="834d0751-5f8e-4289-80c8-46565fad6767";
	private String redirect_uri="http://localhost:8080/openbanking/callback";
	private String grant_type="authorization_code"; // 요청명세를 할 때 grant 값을 지정해라, 3중 인증을 위해서 
	
	
	//REST API 요청
	private RestTemplate restTemplate;
	
	//헤더 정보 관리 클래스
	private HttpHeaders httpHeaders;
	
	
	
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		
		//		요청 메시지 URL
		//HTTP URL 	https://testapi.openbanking.or.kr/oauth/2.0/token
		//HTTP Method POST
		//Content-Type application/x-www-form-urlencoded; charset=UTF-8
		//요청값code client_id client_secret redirect_uri grant_type
		
		
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		//Content-Type 지정 http header
		httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		requestTokenVO.setRequestToken(client_id, client_secret, redirect_uri, grant_type);
		// application/x-www-form-urlencoded; charset=UTF-8" 객체저장 불가능
		// JSON 형태는 Object를 못 가져가서 파라미터된 값으로 변경해야 함
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("code", requestTokenVO.getCode());
		parameters.add("client_id", requestTokenVO.getClient_id());
		parameters.add("client_secret", requestTokenVO.getClient_secret());
		parameters.add("redirect_uri", requestTokenVO.getRedirect_uri());
		parameters.add("grant_type", requestTokenVO.getGrant_type());
		
		
		//HttpHeader, HttpBody에 parameters를 담아서 감 => HttpEntity
		HttpEntity<MultiValueMap<String, String>> param = new HttpEntity<MultiValueMap<String,String>>(parameters,httpHeaders);
		
		System.out.println("@@@@@@param : "+ param);
		
		String requestUrl="https://testapi.openbanking.or.kr/oauth/2.0/token";
		return restTemplate.exchange(requestUrl, HttpMethod.POST, param, ResponseTokenVO.class).getBody();
	}
}

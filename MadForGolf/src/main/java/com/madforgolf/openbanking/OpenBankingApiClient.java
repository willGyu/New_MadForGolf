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
	
	private String client_id="6f948a13-11af-4892-b746-ee67d358abf2";
	private String client_secret="4008271b-939d-4ee9-a981-5a132490eafc";
	private String redirect_uri="http://localhost:8088/fintech/callback";
	private String grant_type="authorization_code";
	
	
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

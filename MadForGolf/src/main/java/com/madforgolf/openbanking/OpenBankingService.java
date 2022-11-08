package com.madforgolf.openbanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.openbanking.domain.RequestTokenVO;
import com.madforgolf.openbanking.domain.ResponseTokenVO;

@Service
public class OpenBankingService {
	
	
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingApiClient openBankingApiClient;
	
	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		
		System.out.println("@@@@@@@@@@@ 2. openbanking service - requestToken() ");
		
		return openBankingApiClient.requestToken(requestTokenVO);
	}
		
}

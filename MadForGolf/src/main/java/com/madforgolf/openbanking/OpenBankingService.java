package com.madforgolf.openbanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.ProductVO;
import com.madforgolf.openbanking.domain.AccountSearchRequestVO;
import com.madforgolf.openbanking.domain.AccountSearchResponseVO;
import com.madforgolf.openbanking.domain.DepositRequestVO;
import com.madforgolf.openbanking.domain.DepositResponseVO;
import com.madforgolf.openbanking.domain.RequestTokenVO;
import com.madforgolf.openbanking.domain.ResponseTokenVO;
import com.madforgolf.openbanking.domain.UserInfoRequestVO;
import com.madforgolf.openbanking.domain.UserInfoResponseVO;
import com.madforgolf.openbanking.domain.WithdrawRequestVO;
import com.madforgolf.openbanking.domain.WithdrawResponseVO;

@Service
public class OpenBankingService {
	
	
	// OpenBankingApiClient 객체생성
	@Autowired
	private OpenBankingApiClient openBankingApiClient;
	
	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) throws Exception {
		
		System.out.println("@@@@@@@@@@@ 2. openbanking service - requestToken() ");
		
		return openBankingApiClient.requestToken(requestTokenVO);
	}

	
	
	//-------------------------------------------------------------------------------------------
	
	
	
	//사용자 정보 조회
	public UserInfoResponseVO findUser(UserInfoRequestVO userInfoRequestVO) throws Exception {
		
		System.out.println("@@@@@@@@@@@ 2. openbanking service - findUser() ");
		
		return openBankingApiClient.findUser(userInfoRequestVO);
	}

	
	

	//-------------------------------------------------------------------------------------------
	
	
	
	// 등록계좌 조회
	public AccountSearchResponseVO findAccount(AccountSearchRequestVO accountSearchRequestVO) throws Exception {
		
		System.out.println("@@@@@@@@@@@ 2. openbanking service - findAccount() ");

		return openBankingApiClient.findAccount(accountSearchRequestVO);
	}


	
	
	//-------------------------------------------------------------------------------------------
	
	
	
	
	// 출금입금
	public WithdrawResponseVO getwithdraw( WithdrawRequestVO withdrawRequestVO) {
		return openBankingApiClient.withdraw(withdrawRequestVO);
	}
	
	
	
	
	
	//-------------------------------------------------------------------------------------------
	
	
	
	// 입금이체
	public DepositResponseVO getDeposit( DepositRequestVO depositRequestVO) throws Exception {
		
		return openBankingApiClient.deposit(depositRequestVO);
	}
	
	
	
	
	
	
}

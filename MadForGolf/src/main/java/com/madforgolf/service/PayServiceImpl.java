package com.madforgolf.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madforgolf.domain.PayVO;
import com.madforgolf.persistence.PayDAO;

@Service
public class PayServiceImpl implements PayService{
	
private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	//객체 생성
	@Inject
	private PayDAO dao;
	
	
	@Override
	public void payInsert(PayVO vo) {
		dao.payInsert(vo);
	}
	
}

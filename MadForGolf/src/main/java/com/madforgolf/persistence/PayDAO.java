package com.madforgolf.persistence;

import com.madforgolf.domain.PayVO;

public interface PayDAO {
	//결제정보 insert
		public void payInsert(PayVO vo);
}

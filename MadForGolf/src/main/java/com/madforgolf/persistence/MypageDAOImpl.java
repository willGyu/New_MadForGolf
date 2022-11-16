package com.madforgolf.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.madforgolf.domain.DealVO;
import com.madforgolf.domain.LikeListVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;

@Repository
public class MypageDAOImpl implements MypageDAO {
	
	
	
	private static final Logger log = 
			LoggerFactory.getLogger(MemberDAOImpl.class);
	
	
	private static final String NAMESPACE = "com.madforgolf.mapper.mypageMapper";
	
	
	@Inject
	private SqlSession sqlSession;
	
	
	
	// 가계부
	// 월별 구매 금액
	@Override
	public int purchaseMonth(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int purchaseMonth = sqlSession.selectOne(NAMESPACE+".purchaseMonth",user_id);
		log.info("@@@@@@ purcahseMonth : "+purchaseMonth);
		
		return purchaseMonth;
	}

	// 월별 판매 금액
	@Override
	public int saleMonth(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int saleMonth = sqlSession.selectOne(NAMESPACE+".saleMonth",user_id);
		log.info("@@@@@@ saleMonth : "+saleMonth);
		
		return saleMonth;
	}
	
	// 월별 구매 횟수
	@Override
	public int purchaseCnt(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int purchaseCnt = sqlSession.selectOne(NAMESPACE+".purchaseCnt",user_id);
		log.info("@@@@@@ purcahseCnt : "+purchaseCnt);
		
		return purchaseCnt;
	}
	
	// 월별 판매 횟수
	@Override
	public int saleCnt(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int saleCnt = sqlSession.selectOne(NAMESPACE+".saleCnt",user_id);
		log.info("@@@@@@ saleCnt : "+saleCnt);
		
		return saleCnt;
	}

	// 드라이버 구매
	@Override
	public int purchaseDriver(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int purchaseDriver = sqlSession.selectOne(NAMESPACE+".purchaseDriver",user_id);
		log.info("@@@@@@ purchaseDriver : "+purchaseDriver);
		
		return purchaseDriver;
	}

	// 아이언 구매
	@Override
	public int purchaseIron(String user_id) throws Exception {
		
		int purchaseIron = sqlSession.selectOne(NAMESPACE+".purchaseIron",user_id);
		return purchaseIron;
	}
	
	// 유틸리티 구매
	@Override
	public int purchaseUtil(String user_id) throws Exception {
		
		int purchaseUtil = sqlSession.selectOne(NAMESPACE+".purchaseUtil",user_id);
		return purchaseUtil;
	}
	
	// 웨지 구매
	@Override
	public int purchaseWedge(String user_id) throws Exception {
		
		int purchaseWedge = sqlSession.selectOne(NAMESPACE+".purchaseWedge",user_id);
		return purchaseWedge;
	}
	
	// 퍼터 구매
	@Override
	public int purchasePutter(String user_id) throws Exception {
		
		int purchasePutter = sqlSession.selectOne(NAMESPACE+".purchasePutter",user_id);
		return purchasePutter;
	}
	
	// 기타용품 구매
	@Override
	public int purchaseEtc(String user_id) throws Exception {
		
		int purchaseEtc = sqlSession.selectOne(NAMESPACE+".purchaseEtc",user_id);
		return purchaseEtc;
	}
	
	// 드라이버 판매
	@Override
	public int saleDriver(String user_id) throws Exception {
		log.info("@@@@@@@@@@"+user_id);
		
		int saleDriver = sqlSession.selectOne(NAMESPACE+".saleDriver",user_id);
		log.info("@@@@@@ saleDriver : "+saleDriver);
		
		return saleDriver;
	}
	
	// 아이언 판매
	@Override
	public int saleIron(String user_id) throws Exception {
		
		int saleIron = sqlSession.selectOne(NAMESPACE+".saleIron",user_id);
		return saleIron;
	}
	
	// 유틸리티 판매
	@Override
	public int saleUtil(String user_id) throws Exception {
		
		int saleUtil = sqlSession.selectOne(NAMESPACE+".saleUtil",user_id);
		return saleUtil;
	}
	
	// 웨지 판매
	@Override
	public int saleWedge(String user_id) throws Exception {
		
		int saleWedge = sqlSession.selectOne(NAMESPACE+".saleWedge",user_id);
		return saleWedge;
	}
	
	// 퍼터 판매
	@Override
	public int salePutter(String user_id) throws Exception {
		
		int salePutter = sqlSession.selectOne(NAMESPACE+".salePutter",user_id);
		return salePutter;
	}
	
	// 기타용품 판매
	@Override
	public int saleEtc(String user_id) throws Exception {
		
		int saleEtc = sqlSession.selectOne(NAMESPACE+".saleEtc",user_id);
		return saleEtc;
	}
	
	//찜목록
	@Override
	public List<LikeListVO> likeList(PageMakerVO pm, String user_id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pm", pm);
		map.put("user_id", user_id);
		
		return sqlSession.selectList(NAMESPACE+".likeList",map);
	}

	//찜목록 개수
	@Override
	public Integer likeListCnt(PageVO vo, String user_id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", vo);
		map.put("user_id", user_id);
	
		return sqlSession.selectOne(NAMESPACE+".likeListCnt",map);

	}

}

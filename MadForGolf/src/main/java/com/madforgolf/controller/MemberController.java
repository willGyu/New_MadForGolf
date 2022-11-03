package com.madforgolf.controller;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.MemberVO;
import com.madforgolf.service.MemberService;
import com.madforgolf.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 필요(의존적)
	@Inject
	private MemberService service;
	
	
	// ------------------------ 회원가입 시작 ------------------------------------
	
	
	
	// 회원가입 - GET
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insertGET() throws Exception {
		log.info("insertGET() 호출");
		log.info(" /member/sign (get) -> /member/insert.jsp 로 연결");
	}

	// 회원가입 - POST
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(MemberVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("insertPOST() 호출");
		log.info("@@@@@"+vo);
		int result = service.idCheck(vo);

		try {
			if (result == 1) {
				return "/member/insert";
			} else if (result == 0) {
				log.info(vo + "");
				service.insert(vo);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}

		log.info("@@@@@회원가입 성공! ");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입완료!');");
		out.println("location.href='/member/login'");
		out.println("</script>");
		out.close();
	   

		return "redirect:/member/login";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public String idCheck(MemberVO vo) throws Exception {
		log.info("idCheck() 호출");
		log.info("@@@@@@"+vo);
		String result = service.idCheck(vo)+"";
		return result;
	}
		
	// 전화번호 중복 체크
	@ResponseBody
	@RequestMapping(value = "/phoneCheck", method = RequestMethod.POST)
	public String phoneCheck(MemberVO vo) throws Exception {
		log.info("phoneCheck() 호출");
		log.info("@@@@@@"+vo);
		String result = service.phoneCheck(vo)+"";
		return result;
	}
	
	
	
	// ---------------------------------- 카카오 로그인 ---------------------------------------------
//	@RequestMapping(value="/kakaoLogin")
//	public @ResponseBody String KaKaoAuthUrl() throws Exception{
//		String kakaoUri = "https://kauth.kakao.com/oauth/authorize?client_id=a1e9c36223914cdc6e0edf2ff5f92f81&redirect_uri=http://localhost:8088/member/kakaoLogin&response_type=code";
//		log.info("code 설정");
//		
//		return kakaoUri;
//	}
	
	
	@RequestMapping(value="/kakaoLogin",method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value="code",required=false) String code) throws Exception{
		
		log.info("@@@@@@ 카카오"+code);
		
		String access_Token = service.getAccessToken(code);
		log.info("@@@@@@@@@@ 카카오토큰 : "+access_Token);
		
		return "/member/testPage";
	}
	
	
	
	// ------------------------ 회원가입 끝 ------------------------------------
		
	
	
		
	// ------------------------ 로그인, 로그아웃 ------------------------------------
		
		
	
	// http://localhost:8088/member/login
	// 로그인 - GET
	@RequestMapping(value = "/login",method = RequestMethod.GET )
	public String login() throws Exception {
		log.info(" login() 실행 ");
		log.info(" 연결된 뷰 페이지로 이동 ");
					
		return "/member/login";
	}
					
	// 로그인 - POST
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(MemberVO vo, HttpSession session, RedirectAttributes rttr, Model model) throws Exception {
		log.info(" loginPOST() 호출 ");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		//  String id = request.getParameter("id");
		//  vo.setUser_id(id);
		//  vo.setUser_id(request.getParameter("user_id"));
		//  log.info("controller user_id : " + id);
		                    
		//  log.info("user_id" + user_id);
		                            
		log.info("@@@@ login : "+vo);
		                            
		MemberVO loginVO = service.login(vo);
		log.info("**** loginVO : "+loginVO);
		                                    
		// 로그인 여부 확인
		if(loginVO != null) {
		                    
		session.setAttribute("user_id", loginVO.getUser_id());
		session.setAttribute("loginVO", loginVO);
		String user_id = (String)session.getAttribute("user_id");
		log.info(user_id + "세션값");
		                                        
		//  session.setAttribute("loginVO", loginVO);
		//  log.info(loginVO+" 세션값 ");
		                                    
		return "redirect:index";
		                            
		}else {
	                                
			// 실패 -> 로그인페이지 이동
	                    
			return "/member/msg";
	                                
		}
	}
	
	
	
	// http://localhost:8088/member/main
	// 메인페이지 -  GET    
	@RequestMapping(value = "index", method = RequestMethod.GET )
	public String main() {
		log.info(" mainGET() 호출 ");
		log.info(" void 리턴 : /main.jsp 뷰 호출 ");
			
		return "index";
	}
				
	// http://localhost:8088/member/mypage
	// 마이페이지 -  GET    
	@RequestMapping(value = "/mypage", method = RequestMethod.GET )
	public String mypage() {
		log.info(" mypage() 호출 ");			
		log.info(" void 리턴 : /mypage.jsp 뷰 호출 ");
					
		return "member/mypage";
	}
				
				
	// 로그아웃 GET/POST
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 로그아웃 -> 세션초기화
		session.invalidate();
		log.info(" 세션 초기화 완료 => 로그아웃 ");
					
		// 페이지 이동	
		return "redirect:/index";
	}
			
			
		

	// ------------------------ 로그인, 로그아웃 끝 ------------------------------------
			
	
			
	// ------------------------ 아이디, 비밀번호 찾기 시작 ------------------------------------
	// 아이디 찾기
	@RequestMapping(value="/findId",method=RequestMethod.GET)
	public String findIdGET() throws Exception {
		log.info("findIdGET() 호출");
				
		return "member/findId";
	}
			
	@RequestMapping(value="/findId",method=RequestMethod.POST)
	public String findIdPOST(MemberVO vo, Model model) throws Exception {
		log.info("findIdPOST(MemberVO vo, Model model) 호출");
				
		MemberVO findIdVo = service.findId(vo);
		// System.out.println(findIdVo.getUser_id());
				
		if(findIdVo == null) {
			model.addAttribute("check",1);
				return "/member/msg";
		}else {
			model.addAttribute("check", 0);
			model.addAttribute("user_id", findIdVo.getUser_id());
			return "/member/resultId";
		}
				
	}
			
	// 아이디 결과
	@RequestMapping(value="/resultId", method=RequestMethod.GET)
	public String resultIdGET(HttpServletRequest request,Model model, @RequestParam(required=false,value="user_name") String user_name, @RequestParam(required=false,value="user_phone") String user_phone, MemberVO searchVO) throws Exception{
				
		searchVO.setUser_name(user_name);
		searchVO.setUser_phone(user_phone);
		MemberVO findId = service.findId(searchVO);
				
				
		model.addAttribute("searchVO", findId);
				
				
		return "member/resultId";
	}
			
			
			
	// 비밀번호 찾기
	@RequestMapping(value="/findPw",method=RequestMethod.GET)
	public String findPwGET() throws Exception {
		log.info("findPwGET() 호출");
				
		return "member/findPw";
	}
			
	@RequestMapping(value="/findPw",method= RequestMethod.POST)
	public String findPwPOST(MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception{
		log.info("findPwPOST(MemberVO vo, Model model) 호출");
				
		log.info("@@@@@@@@@@@@@@"+vo);
				
		// System.out.println("입력한 정보: "+vo);
		MemberVO findPwVo = service.findPw(vo);
		// String pw = findPwVo.getUser_pw();
		log.info("가져온정보: "+findPwVo);
				
		if(findPwVo == null) {
			rttr.addFlashAttribute("check",1);
			return "/member/msg";
		}else {
			findPwVo.setUser_id(vo.getUser_id());
			rttr.addFlashAttribute("check", 0);
			rttr.addFlashAttribute("findPwVo", findPwVo);
			log.info("가져온정보: "+findPwVo);
			return "redirect:/member/updatePw";
		}
				
	}
			
			
			
	// 비밀번호 변경 GET
	@RequestMapping(value="/updatePw",method=RequestMethod.GET)
	public void updatePwGET(@RequestParam(value="updatePw", defaultValue="", required=false) String user_id, MemberVO vo) throws Exception{
		log.info("updatePwGET() 호출");
	}
			
	// 비밀번호 변경 POST
	@RequestMapping(value="/member/updatePw",method=RequestMethod.POST)
	public String updatePwPOST(@RequestParam(value="updatePw", defaultValue="", required=false) String user_id, MemberVO vo) throws Exception{
		log.info("updatePwPOST() 호출");
		log.info(""+vo);
		// vo.setUser_id("user_id");
		service.updatePw(vo);
				
		return "redirect:/member/login";
	}
	// ------------------------ 아이디, 비밀번호 찾기 끝 ------------------------------------
			
			
			
	// ------------------------ 회원 정보 수정 시작 ------------------------
			
			
			
	// 가상주소 http://localhost:8080/FunWeb/member/update
	// => /WEB-INF/views/member/update.jsp
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		// 세션값 가져오기
		String id =(String)session.getAttribute("user_id");
					
		// 수정할 정보 가지고 감.
		MemberVO vo=service.getMember(id);
//		request.setAttribute("vo",vo);
		model.addAttribute("vo",vo);
		log.info("@@@@@" + id+"");
		// 가상주소 변경없이 jsp 이동
		//  /WEB-INF/views/member/update.jsp
		return "member/update";
		// redirect:/ (==) /index
	}
				
				
	// 가상주소 http://localhost:8080/FunWeb/member/updatePro
	// 수정처리 메시지 "MemberController updatePro()"
	// 가상주소 redirect:/main/main 이동
	@RequestMapping(value = "/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberVO vo) {
					  
		log.info( "updatePro() 호출");
		// loginMember 비밀번호 일치 여부 확인
		MemberVO vo2=service.loginMember(vo);
		// 아이디 비밀번호 일치 => 수정처리 => /main/main 이동
		// 아이디 비밀번호  틀림  => msg.jsp  뒤로이동
		if(vo2!=null) {
			// 아이디 비밀번호 일치
			//수정처리
			int result=service.updateMember(vo);
			// 메인 페이지로 이동
			// 주소가 변경되면서 가상주소 이동
//			response.sendRedirect() 
			return "/member/login";
		}else {
			// 아이디 비밀번호 틀림
//			System.out.println("틀림");
			//  /WEB-INF/views/member/msg.jsp
			return "/member/msg";
		}
	}
		
	// ------------------------ 회원 정보 수정 끝 ------------------------
	
			
	
	// ------------------------ 회원 탈퇴 시작 ------------------------
	// http://localhost:8080/member/delete
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public void deleteGET() throws Exception {
		log.info("deleteGET() 호출");
				
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deletePOST(MemberVO dvo, HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("deletePOST() 호출");
		log.info("Controller @@@@@@"+dvo);
				
		MemberVO deleteVo = (MemberVO)session.getAttribute("loginVO");
				
		log.info("가져온정보: "+dvo);
				
				
		String voPw = dvo.getUser_pw();
		String sessionPw = deleteVo.getUser_pw();
				
		if(!(sessionPw.equals(voPw))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/delete";
		}
				
		service.deleteMember(dvo);
		session.invalidate();
				
		log.info("회원탈퇴 성공");
				
		return "redirect:index";
				
				
	}
	
	
	
	// 비밀번호 체크
	@ResponseBody
	@RequestMapping(value="/pwCheck",method=RequestMethod.POST)
	public int pwCheck(MemberVO vo) throws Exception{
		int result = service.pwCheck(vo);
				
		return result;
	}
	
	
	// ------------------------ 회원 탈퇴 끝 ------------------------
}

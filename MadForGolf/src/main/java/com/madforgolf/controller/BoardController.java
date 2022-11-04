package com.madforgolf.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.MemberVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;
import com.madforgolf.domain.ProductVO;
import com.madforgolf.domain.ReplyVO;
import com.madforgolf.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	
	

	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//글쓰기 페이지 불러오기
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String insertBoardGET(HttpSession session, Model model) throws Exception{
		log.info(" 1. controller - insertBoardGET() 호출 ");
		
		String user_id = (String)session.getAttribute("user_id");
//		log.info("############"+user_id);
		
		String user_name = service.getUser_name(user_id);
		
//		log.info("############# controller user_name : "+user_name);
		model.addAttribute("user_name",user_name);
		session.setAttribute("user_id", user_id);
		
		return "/board/insertBoard";
//		log.info(" /board/insertBoard (get) -> board/insertBoard.jsp");
	}
	

	
	//--------------------------------------------------------------------------------------------------

	
	
	
	//게시글 작성 - 다중업로드
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoardPOST(BoardVO vo, MultipartHttpServletRequest multi, HttpServletRequest request) throws Exception{
		log.info(" 1. controller - insertBoardPOST() 호출");
		
		log.info("multi : "+multi);
		
		//파일 정보 저장
		Map<String, String> map = new HashMap<String, String>();
		
		//파일 외 정보들 저장
		Enumeration<String> enu = multi.getParameterNames();
		log.info("multi : "+multi);
		
		
		//파일 외 정보들 while문으로 Map에 저장
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			log.info("name : " + name);
			String value = multi.getParameter(name);
			log.info("value : " + value);
			map.put(name, value);
		}
		log.info("map : "+map);
		
		//DB 저장을 위해서 Map에서 VO로 옮기기
		vo.setBoard_category((String)map.get("board_category"));
		vo.setUser_id((String)map.get("user_id"));
		vo.setUser_name((String)map.get("user_namd"));
		vo.setTitle((String)map.get("title"));
		vo.setContent((String)map.get("content"));
		
		log.info("########## vo: "+ vo);
		
		// 업로드 파일 Map에 삽입
		map.put("fileList", fileProcess(multi)) ;
		vo.setContent_file((String)map.get("fileList"));
		log.info("######### 최종 vo : " + vo);

		
		service.boardWrite(vo);
		
		log.info(" 4. controller - 글쓰기 완료 ");
		
		
		
		//페이지 이동(리스트)
		return "redirect:/board/listBoardAll";
	}
	
	
	
	//파일 처리 전용 메서드
	public String fileProcess(MultipartHttpServletRequest multi)throws Exception{
		log.info("첨부파일 처리 시작");
		
		//파일의 원래 이름을 담을 리스트 준비
		List<String> fileList = new ArrayList<String>();
		String uploadFileName = "";
		
		//파일 정보를 Interator에 불러서 담아주기
		Iterator<String> fileNames = multi.getFileNames();
		
		while(fileNames.hasNext()) {
			
			//파일의 파라미터명(name)
			String filename = fileNames.next();
			log.info("파일 파라미터명 : "+filename );
			
			//파일 정보 가져오기
			MultipartFile mfile = multi.getFile(filename);
			
			//파일의 원래 이름 가져오기
			String ofileName = mfile.getOriginalFilename();
			
			//파일 확장자 가져오기
			String fileExtention = ofileName.substring(ofileName.lastIndexOf("."),ofileName.length());
			
			//파일 저장위치
			String uploadFolder = "C:\\Users\\Hazle_dandan\\git\\New";
			
			log.info("파일의 원래 이름 : " + ofileName);
			//파일 이름 저장
			fileList.add(ofileName);
			
			//파일명 중복을 위해서 랜덤으로 변경
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			System.out.println("생성된 고유 파일명 : " + uniqueName);
			System.out.println("파일 확장자 : "+ fileExtention);
			
			//저장소에 저장될 바뀔 파일명
			uploadFileName = uniqueName + fileExtention;
			
			//파일을 저장소에 저장하기 위한 파일 객체 생성 후 지정
			//지정된 위치에 파일 저장
			File file = new File(uploadFolder+"\\"+uploadFileName);
			
			//멀티파트로 가져온 파일의 사이즈가 0이 아닐 때 == 파일이 있을 때
			if(mfile.getSize() != 0) {
				//첨부파일 업로드
				mfile.transferTo(file);
				log.info("파일 업로드 성공");
			}//if문 종료
		}//while문 종료
		log.info("첨부파일 처리 끝");
		return uploadFileName;
	}//게시글 등록
	
	
	
	
	//--------------------------------------------------------------------------------------------------

	
	
	
	
	// 글내용
	// http://localhost:8088/board/boardRead?board_num=1
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public void boardReadGET(PageVO vo, HttpSession session, @RequestParam("board_num") int board_num, Model model)
			throws Exception {
		log.info(" registerGET() 호출 ");
		log.info(board_num + " --------------bno");

		// 세션으로 넘어온 값 확인
		log.info("############################isUpdate : " + session.getAttribute("isUpdate"));
		boolean isUpdate = (boolean) session.getAttribute("isUpdate");
		if (!isUpdate) {
			service.updateReadCount(board_num);
			log.info("조회수 1증가!!!띠용");
			session.setAttribute("isUpdate", true);
		}
		//	vo.setPage(2);
		//	vo.setPerPageNum(5);

			
		model.addAttribute("vo", service.getBoard(board_num));
		// 오류 생기는 곳 ==============================================
		//댓글출력
		model.addAttribute("replyVO", service.getReply(board_num, vo));
		log.info(board_num+"번 글의 댓글 불러오기 성공");
		//페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(service.replyCnt(board_num));
		if(service.replyCnt(board_num) == 0) {
			model.addAttribute("msg", "NO");
		}
				
		//log.info("################################### 뭐임 : "+ service.getReply(board_num, vo));		
		log.info("################################### 댓글수 : "+ service.replyCnt(board_num));		
		//log.info("################################### vo : "+ vo + "pm" + pm);		
		model.addAttribute("pm", pm);
	}
	
	
	//--------------------------------------------------------------------------------------------------

	
	

	
	
	//글 수정하기 - GET(기존의 정보 조회 출력 + 수정할 정보 입력)
	@RequestMapping(value="/boardModify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("board_num") int board_num, Model model) throws Exception{
		
		//연결된 뷰로 전달
		model.addAttribute("vo", service.getBoard(board_num));
		
		//페이지 이동(출력) /board/modify.jsp
	}
	
	
	//--------------------------------------------------------------------------------------------------

	
	


	

	
	//글 수정하기 - POST(수정할 데이터 처리)
	@RequestMapping(value="/boardModify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		
		//전달 정보 저장
		log.info("################################" + vo);
		 
		//서비스 - 글 정보 수정
		int cnt = service.updateBoard(vo);
		
		if(cnt == 1) {
			//수정 성공 시 /listAll 페이지 이동
			rttr.addFlashAttribute("msg", "UPDATEOK");
			return "redirect:/board/boardRead?board_num="+vo.getBoard_num();
		} else {
			//수정 실패 시
			return "/board/boardModify?bno="+vo.getBoard_num();
		}
		
	}
	

	
	
	
	//--------------------------------------------------------------------------------------------------

	

	
	
	//글 삭제하기
	@RequestMapping(value="/boardDelete", method = RequestMethod.GET)
	public String delete(@RequestParam("board_num") int board_num, RedirectAttributes rttr) throws Exception{
		//전달 정보 저장
		
		//서비스 - 글 삭제
		service.deleteBoard(board_num);
		
		log.info("글 삭제 완료");
		rttr.addFlashAttribute("msg", "DELETEOK");
		
		return "redirect:/board/listPage";
	}
	
	




	
	//--------------------------------------------------------------------------------------------------

	
	
	
	
	
	//게시판 리스트(페이징 처리) - GET
	@RequestMapping(value = "/listBoardAll", method = RequestMethod.GET)
	public String listBoardAllGET(Model model,PageVO vo,HttpSession session) throws Exception{
		log.info(" 1. controller - listBoardAllGET ");
		
		String user_id = (String)session.getAttribute("user_id");
		log.info("############"+user_id);
		
		session.setAttribute("user_id", user_id);
		model.addAttribute("boardList", service.listPage(vo));
		
		
		//페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(385);
		model.addAttribute("pm", pm);
		
		session.setAttribute("isUpdate", false); //조회수 때문에 주는 것
			
		return "/board/listBoardAll";
	}
	
	
	
	

	
	//--------------------------------------------------------------------------------------------------
	
	
	//게시판 리스트(말머리) - GET
	@RequestMapping(value = "/listBoardCategory", method = RequestMethod.GET)
	public String listBoardCategory(Model model,PageVO vo,@RequestParam("board_category") String board_category,HttpSession session) throws Exception{
		log.info(" 1. controller - listBoardCategory() ");
		
		String user_id = (String)session.getAttribute("user_id");
		log.info("############"+user_id);
		
		session.setAttribute("user_id", user_id);
		model.addAttribute("boardList", service.listCategory(vo,board_category));
		
		//페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(500);
		
		log.info("################################### vo : "+ vo);
		log.info("################################### pm :" + pm);
		
		
		model.addAttribute("pm", pm);
		session.setAttribute("isUpdate", false); //조회수 때문에 주는 것

		return"/board/listBoardCategory";
	}
	
	
	
	
	//--------------------------------------------------------------------------------------------------
	
	
	
	//댓글쓰기
		@RequestMapping(value="/insertReply", method = RequestMethod.POST)
		public String insertReply(RedirectAttributes rttr, ReplyVO vo) throws Exception{
			//전달 정보 저장
			
			//서비스 - 글 삭제
			service.insertReply(vo);
			
			log.info("댓글쓰기 완료");
			rttr.addFlashAttribute("msg", "INSERTOK");
			
			return "redirect:/board/boardRead?board_num="+vo.getBoard_num();
		}
		


		
		//--------------------------------------------------------------------------------------------------
		
		

		//댓글삭제
		@RequestMapping(value="/deleteReply", method = RequestMethod.GET)
		public String deleteReply(@RequestParam("reply_num") int reply_num, @RequestParam("board_num") int board_num, RedirectAttributes rttr) throws Exception{
			//전달 정보 저장
			log.info(reply_num + "@@@@@@@@@@@" + board_num);
			//서비스 - 글 삭제
			service.deleteReply(reply_num);
			
			log.info("댓글쓰기 삭제");
			rttr.addFlashAttribute("msg", "DELETEOK");
			
			return "redirect:/board/boardRead?board_num="+board_num;
		}

		
		//--------------------------------------------------------------------------------------------------
		

		
		//댓글 수정
		@RequestMapping(value="/updateReply", method = RequestMethod.POST)
		public String updateReply(@RequestParam("reply_num") int reply_num, @RequestParam("board_num") int board_num, ReplyVO vo, RedirectAttributes rttr) throws Exception{
			//전달 정보 저장
			log.info(reply_num + "@@@@@@@@@@@" + board_num+"@@@@@@@@@@@@@@@@@@@");
			//int page = (Integer.parseInt(request.getParameter("page")));
			//서비스 - 댓글수정
			service.updateReply(vo);
			
			log.info("댓글 수정 완료");
			rttr.addFlashAttribute("msg", "UPDATEOK");
			
			return "redirect:/board/boardRead?board_num="+board_num;
		}
		
		
		//-------------------------------------------------------------------------------------------------------
		


}

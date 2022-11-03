package com.madforgolf.controller;

import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.madforgolf.domain.BoardVO;
import com.madforgolf.domain.MemberVO;
import com.madforgolf.domain.PageMakerVO;
import com.madforgolf.domain.PageVO;
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
	public void insertBoardGET() throws Exception{
		log.info(" 1. controller - insertBoardGET() 호출 ");
//		log.info(" /board/insertBoard (get) -> board/insertBoard.jsp");
	}
	

	
	//--------------------------------------------------------------------------------------------------

	
	
	
	//글 작성해서 DB에 삽입
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoardPOST(BoardVO vo, @RequestParam("img") MultipartFile img,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirect) throws Exception{
		log.info(" 1. controller - insertBoardPOST() 호출");
		
		//한글 처리
		//전달된 정보 저장
		
		log.info("@@@@@@@@@@@@@@@@@@@@@@@vo: "+vo);
		
		// 파일 개요
		String fileRealName = file.getOriginalFilename();
		long fileSize = file.getSize();
		log.info("파일명 : " + fileRealName);
		log.info("용량(Byte) : " + fileSize);
		
		// 이미지파일 개요
		String imgRealName = img.getOriginalFilename();
		long imgSize = img.getSize();
		log.info("이미지명 : " + imgRealName);
		log.info("용량(Byte) : " + imgSize);
		
		// 파일 등록 - 등록되는 파일 경로
		// (!important) 파일 경로 일치 필요
//		String uploadFolder = "C:\\Users\\ITWILL\\git\\mad4golf_Test12\\src\\main\\webapp\\resources\\product_img";
		String uploadFolder = "C:\\Users\\ITWILL\\git\\New_MadForGolf\\MadForGolf\\src\\main\\webapp\\resources\\board_file";
				
		// 파일 등록 - 파일 이름 랜덤 생성(이름 중복 방지)
		UUID fileUuid = UUID.randomUUID();
		log.info("fileUUID : " + fileUuid);
		String[] fileUuids = fileUuid.toString().split("-");
		String fileUniqueName = fileUuids[0];
		
		// 사진 등록 - 사진 이름 랜덤 생성(이름 중복 방지)
		UUID imgUuid = UUID.randomUUID();
		log.info("imgUUID : " + imgUuid);
		String[] imgUuids = imgUuid.toString().split("-");
		String imgUniqueName = imgUuids[0];
		
		// 파일 등록 - 확장자명 만들기
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
		
		// 사진 등록 - 확장자명 만들기
		String imgExtension = imgRealName.substring(imgRealName.lastIndexOf("."), imgRealName.length());
		
		log.info("파일 - 생성된 고유문자열 : " + fileUniqueName);
		log.info("파일 - 확장자명 : " + fileExtension);
		
		log.info("사진 - 생성된 고유문자열 : " + imgUniqueName);
		log.info("사진 - 확장자명 : " + imgExtension);
		
		// 파일 등록
		java.io.File saveFile = new java.io.File(uploadFolder + "\\" + fileUniqueName + fileExtension);
		java.io.File saveImgFile = new java.io.File(uploadFolder + "\\" + imgUniqueName + imgExtension);
		

		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드
			img.transferTo(saveImgFile); // 실제 사진 저장메서드
			log.info("file : " + file.toString());
			log.info("imgFile : " + img.toString());
			
			log.info("파일&사진 등록 완료!");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
				
		log.info("vo : " + vo);

		
		// 서비스 - DB에 상품 등록
		vo.setContent_img(imgUniqueName + imgExtension);
		vo.setContent_file(fileUniqueName + fileExtension);
		
		log.info("vo : " + vo);

		
		service.boardWrite(vo);
		
		log.info(" 4. controller - 글쓰기 완료 ");
		
		
		
		//페이지 이동(리스트)
//		return "redirect:/board/listAll?msg=writeOk";
		return "redirect:/board/listBoardAll";
	}
	
	
	
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
	public String listBoardCategory(Model model,PageVO vo,@RequestParam("board_category") String board_category,HttpServletRequest request,HttpSession session) throws Exception{
		log.info(" 1. controller - listBoardCategory() ");
		
//		log.info("##############board_category"+board_category);
		
		session = request.getSession();
//		log.info(session.getAttribute("user_id")+"지금오류찾는중@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		log.info(session.getAttribute("MemberVO")+"지금오류찾는중@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//MemberVO memberVO = (MemberVO)session.getAttribute("MemberVO");
		
		//String user_id = memberVO.getUser_id();
		//session.setAttribute("user_id", user_id);
		
		model.addAttribute("boardList", service.listCategory(vo,board_category));
		
		//페이징 처리 하단부 정보 저장
		PageMakerVO pm = new PageMakerVO();
		pm.setVo(vo);
		pm.setTotalCnt(500);
		
//		log.info("################################### vo : "+ vo);
//		log.info("################################### pm :" + pm);
		
		
		model.addAttribute("pm", pm);
		
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

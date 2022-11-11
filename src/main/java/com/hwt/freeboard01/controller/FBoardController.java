package com.hwt.freeboard01.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwt.freeboard01.dao.mapper.IDao;
import com.hwt.freeboard01.dto.FreeBoardDto;
import com.hwt.freeboard01.dto.MemberDto;

@Controller
public class FBoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@RequestMapping(value = "joinMember")
	public String joinMember() {
		
		return "joinMember";
	}
	
	@RequestMapping(value = "joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkIdFlag = dao.checkIdDao(request.getParameter("mid"));
		//checkIdFlag 값이 1이면 이미 가입하려는 아이디가 db에 존재, 0이면 가입 가능
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		if (checkIdFlag == 0) {
			dao.joinMemberDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
			model.addAttribute("mname", request.getParameter("mname"));
		}
		return "joinOk";
	}
	
	@RequestMapping(value = "checkId")
	public String checkId(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		int checkIdFlag = dao.checkIdDao(request.getParameter("checkId"));
		//checkIdFlag 값이 1이면 이미 가입하려는 아이디가 db에 존재, 0이면 가입 가능
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		return "checkId";
	}
	
	@RequestMapping(value = "/")
	public String login() {
		
		return "login";
	}
	@RequestMapping(value = "loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		
	  String mid = request.getParameter("mid");	
	  String mpw = request.getParameter("mpw");	
	  
	  IDao dao = sqlSession.getMapper(IDao.class);
	  
	  int checkIdFlag = dao.checkIdDao(mid);
	  int checkPwFlag = dao.checkPwDao(mid,mpw);
	  
	  model.addAttribute("checkIdFlag",checkIdFlag);
	  model.addAttribute("checkPwFlag",checkPwFlag);
	  model.addAttribute("mid",mid);
	  
	  if(checkPwFlag == 1) {//로그인 성공시 세션에 아이디와 로그인 유효값을 설정
		  
		  HttpSession session =request.getSession();
		  
		  session.setAttribute("sessionId", mid);
		  session.setAttribute("ValidMem", "yes");
		  
		  MemberDto dto =dao.memberInfoDao(mid);
		  String mname = dto.getMname();
		  String imid = dto.getMid(); 
		  
		  model.addAttribute("mname",mname);
		  model.addAttribute("mid", imid);
	  }else {
		  model.addAttribute("mname","guest");
	  }
	  
	  return "loginOk";
	}
	@RequestMapping(value = "writeForm")
	public String writeForm(HttpServletRequest request, Model model) {
		
		
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		HttpSession session =request.getSession();
		String sid = (String)session.getAttribute("sessionId");
		
		if(sid == null) {
			return "redirect:login";
		}else {
		
		MemberDto dto =dao.memberInfoDao(sid);
	  	String mname = dto.getMname();
	  	String mid = dto.getMid();
		  
	  	model.addAttribute("mname",mname);
	  	model.addAttribute("mid",mid);
		
		return "writeForm";
		}
	}
	
	
	@RequestMapping(value = "write")
		public String write(HttpServletRequest request, Model model) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		HttpSession session =request.getSession();
		String sid = (String)session.getAttribute("sessionId");
		
//		String mname="";
//		String mid ="";
//		
//		if(sid.equals(null)) {
//			mname="손님";
//			mid ="guest";
//		}else {
		
		MemberDto dto =dao.memberInfoDao(sid);
		String mname = dto.getMname();
		String mid = dto.getMid();
//		}
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		
		
		dao.writeDao(mid, mname, ftitle, fcontent);
		
	  	
	  	return "redirect:list";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		HttpSession session =request.getSession();
		session.invalidate();//로그아웃 (세션삭제)
		
		
		return "logout";
	}
	
	@RequestMapping(value = "member_list")
	public String member_list(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		  
		String mid = request.getParameter("mid");
		MemberDto dto =dao.memberInfoDao(mid);

	  	
		model.addAttribute("minfo",dto);
		
		
		return "member_list";
	}
	@RequestMapping(value = "member_delete")
	public String member_delete(HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String mid = request.getParameter("mid");
		dao.member_deleteDao(mid);
		return "member_delete";
	}
	
	@RequestMapping(value = "list")
	public String list( Model model, HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<FreeBoardDto> boardDtos = dao.listDao();
		
		HttpSession session = request.getSession();
		
		String sid = (String)session.getAttribute("sessionId");
		if(sid !=null) {
		
		MemberDto dto =  dao.memberInfoDao(sid);
		String mid =dto.getMid();
		model.addAttribute("mid",mid);
		}
		model.addAttribute("boardSum",boardDtos.size());
		model.addAttribute("list",boardDtos);
		
		
		return "list";
	}
	@RequestMapping(value = "content_view")
	public String content_view(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String fnum = request.getParameter("fnum");
		FreeBoardDto dto = dao.content_viewDao(fnum);
		HttpSession session = request.getSession(); //현재 세션 가져오기
		
		String sid = session.getAttribute("sessionId").toString();
		
		String fid = dto.getFid();//현재 보고있는 글을 쓴 아이디
		
		
		int idflag = 0;
		if((sid != fid)&&(sid.equals(fid))) {
			idflag = 1;
		}
			model.addAttribute("idflag",idflag);//idflag = 1이면 수정 삭제 권한 설정
		
	
		
		dao.hitDao(fnum);
		
	  	
		model.addAttribute("fbdto",dto);
		
		
		return "content_view";
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String fnum = request.getParameter("fnum");
		dao.deleteDao(fnum);
		return "redirect:list";
	}
	
	@RequestMapping(value = "modify")
	public String modify(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String fnum = request.getParameter("fnum");
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		dao.modifyDao(fnum, ftitle, fcontent);
		
		
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "modify_view")
	public String modify_view(HttpServletRequest request,Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		String fnum = request.getParameter("fnum");
		FreeBoardDto dto = dao.content_viewDao(fnum);
		
	  	
		model.addAttribute("fbdto",dto);
		
		
		return "modify_view";
	}
	
}

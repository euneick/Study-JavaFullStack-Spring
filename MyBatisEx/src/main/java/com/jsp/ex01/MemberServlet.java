package com.jsp.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberDAO memberDAO = new MemberDAO();
		// MemberDAO2 memberDAO2 = new MemberDAO2(); // 실행 안됨, 인터페이스에 어노테이션을 작성하여 MyBatis를 사용 할 수 있다는 것만 알면 됨
		String nextPage = "";
		
		String action = request.getParameter("action");
		
		if (action == null || action.equals("listMembers")) {
			
			List<MemberVO> membersList = memberDAO.selectAllMemberList();
			// List<MemberVO> membersList = memberDAO2.selectAllMemberList();
			
			request.setAttribute("membersList", membersList);
			request.setAttribute("name", memberDAO.selectName());
			request.setAttribute("pwd", memberDAO.selectPwd());
			
			nextPage = "test01/listMembers.jsp";
		}
		else if (action.equals("selectMemberById")) {

			String id = request.getParameter("value");
			
			MemberVO member = new MemberVO();
			member = memberDAO.selectMemberById(id);
			
			request.setAttribute("member", member);

			nextPage = "test01/memberInfo.jsp";
		}
		else if (action.equals("selectMemberByPwd")) {
			
			int pwd = Integer.parseInt(request.getParameter("value"));
			
			List<MemberVO> membersList = memberDAO.selectMemberByPwd(pwd);

			request.setAttribute("membersList", membersList);

			nextPage = "test01/listMembers.jsp";
		}
		else if (action.equals("insertMember")) {
			
			memberDAO.insertMember(request);
			
			nextPage = "/mem.do?action=listMembers";
		}
		else if (action.equals("insertMember2")) {
			
			memberDAO.insertMemberByHashMap(request);
			
			nextPage = "/mem.do?action=listMembers";
		}
		else if (action.equals("memberForm")) {
			
			nextPage = "test01/memberForm.jsp";
		}
		else if (action.equals("updateMember")) {
			
			nextPage = "test01/modMember.jsp";
		}
		else if (action.equals("updateMemberPro")) {
		
			memberDAO.updateMember(request);
			
			nextPage = "/mem.do?action=listMembers";
		}
		else if (action.equals("deleteMember")) {

			int result = memberDAO.deleteMember(request.getParameter("id"));
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('" + (result == 1 ? "삭제 성공" : "삭제 실패") + "');");
			if (result == 1) out.write("location.href = '" + request.getContextPath() + "/mem.do';");
			else out.write("history.go(-1);");
			out.write("</script>");
			
			out.close();

			return;
		}
		else if (action.equals("searchMember")) {
			
			MemberVO memberVO = new MemberVO();
			
			memberVO.setName(request.getParameter("name"));
			memberVO.setEmail(request.getParameter("email"));
			
			List<MemberVO> membersList = memberDAO.searchMember(memberVO);
			
			request.setAttribute("membersList", membersList);

			nextPage = "test01/listMembers.jsp";
		}
		else if (action.equals("foreachSelect")) {
			
			List<String> nameList = new ArrayList<String>();
			
			nameList.add("주몽");			
			nameList.add("온조");			
			nameList.add("박혁거세");
			
			List<MemberVO> membersList = memberDAO.foreachSelect(nameList);
			
			request.setAttribute("membersList", membersList);
			
			nextPage = "test01/listMembers.jsp";	
		}
		else if (action.equals("foreachInsert")) {
			
			List<MemberVO> newMembersList = new ArrayList<MemberVO>();
			
			newMembersList.add(new MemberVO("teajo", "0001", "태조", "1st@joseon.go.kr"));
			newMembersList.add(new MemberVO("jeongjong", "0002", "정종", "2nd@joseon.go.kr"));
			newMembersList.add(new MemberVO("teajong", "0003", "태종", "3rd@joseon.go.kr"));
			newMembersList.add(new MemberVO("sejong", "0004", "세종", "4th@joseon.go.kr"));
			
			memberDAO.foreachInsert(newMembersList);
			
			nextPage = "mem.do?action=listMembers";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

}

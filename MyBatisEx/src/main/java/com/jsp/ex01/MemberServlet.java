package com.jsp.ex01;

import java.io.IOException;
import java.io.PrintWriter;
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
		
		String name = memberDAO.selectName();
		int pwd = memberDAO.selectPwd();
		
		List<MemberVO> membersList = memberDAO.selectAllMemberList();

		request.setAttribute("membersList", membersList);
		request.setAttribute("name", name);
		request.setAttribute("pwd", pwd);

		RequestDispatcher dispatcher = request.getRequestDispatcher("test01/listMembers.jsp");
		dispatcher.forward(request, response);
	}

}

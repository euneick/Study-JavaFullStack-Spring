package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return getViewName(request);
	}

	public ModelAndView result(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("userId", userId);
		modelAndView.addObject("userPw", userPw);

		modelAndView.setViewName(getViewName(request));

		return modelAndView;
	}

	public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return getViewName(request);
	}

	public ModelAndView info(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("id", request.getParameter("id"));
		modelAndView.addObject("pwd", request.getParameter("pwd"));
		modelAndView.addObject("name", request.getParameter("name"));
		modelAndView.addObject("email", request.getParameter("email"));

		modelAndView.setViewName(getViewName(request));

		return modelAndView;
	}

	// request 객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구하는 메소드
	private String getViewName(HttpServletRequest request) throws Exception {

		String contextPath = request.getContextPath();

		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");

		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		// http://localhost:8090/member/listMember.do로 요청시
		int begin = 0; //

		if (!((contextPath == null) || ("".equals(contextPath)))) {
			 // 전체 요청명 의 길이를 구함
			begin = contextPath.length();
		}

		int end;

		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";"); // 요청 uri에 ';'가 있을 경우 ';'문자 위치를 구함
		}
		else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?"); // 요청 uri에 '?'가 있을 경우 '?' 문자 위치를 구함
		}
		else {
			end = uri.length();
		}

		// http://localhost:8090/member/listMember.do로 요청시 먼저 '.do'를 제거한
		// http://localhost:8090/member/listMember를 구한 후,

		// 다시 http://localhost:8090/member/listMember에서 역순으로 첫번째 '/' 위치를 구한 후, 그 뒤의
		// listMember를 구한다.
		String fileName = uri.substring(begin, end);

		if (fileName.indexOf(".") != -1) {
			// 요청명에서 역순으로 최초 '.'의 위치를 구한 후, '.do' 앞에까지의 문자열을 구함
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}

		if (fileName.lastIndexOf("/") != -1) {
			// 요청명에서 역순으로 최초 '/'의 위치를 구한 후, '/' 다음부터의 문자열을 구함
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}

		return fileName;

	}
}

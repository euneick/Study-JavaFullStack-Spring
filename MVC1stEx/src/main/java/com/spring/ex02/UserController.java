package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

	// methodNameResolver 변수, setMethodNameResolver 함수가 상속되어 있음
	
	
	public String openLoginView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// DispatcherServlet으로 전달 할 페이지 이름
		// viewResolver로 경로와 확장자를 맞추기에 페이지 이름만 작성
		return "login";
	}
	
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		
		ModelAndView modelAndView = new ModelAndView();
		
		// 응답 할 데이터들 바인딩
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("userPw", userPw);
		
		// 요청 할 페이지 명 바인딩
		modelAndView.setViewName("result");
		
		return modelAndView;
	}
}

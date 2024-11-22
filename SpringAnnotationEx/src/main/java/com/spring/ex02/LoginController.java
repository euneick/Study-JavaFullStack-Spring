package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value = { "/test/loginForm.do", "/test/loginForm2.do" },
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		return new ModelAndView("test/loginForm");
	}

	@RequestMapping(value = "/test/login.do",
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("userId", request.getParameter("userId"));
		modelAndView.addObject("userName", request.getParameter("userName"));

		modelAndView.setViewName("test/result");
		
		return modelAndView;
	}

	@RequestMapping(value = "/test/login2.do",
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userId") String userId,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "email", required = true) String email) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("userId", userId);
		modelAndView.addObject("userName", userName);
		modelAndView.addObject("email", email);

		modelAndView.setViewName("test/result");
		
		return modelAndView;
	}

	@RequestMapping(value = "/test/login3.do",
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login3(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> info) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("info", info);

		modelAndView.setViewName("test/result");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/test/login4.do",
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login4(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("info") LoginVO loginVO) throws Exception {
		/*
		 *	모든 파라미터를 VO객체에 저장한 후, VO객체를 바인딩하는 것 까지 일괄적으로 처리
		 *	name 속성의 값과 VO 객체의 변수명이 일치해야 getter/setter 메소드가 실행 됨 
		 */		
		
		return new ModelAndView("test/result");
	}
	
	@RequestMapping(value = "/test/login5.do",
			method = { RequestMethod.GET, RequestMethod.POST })
	public String login5(HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		
		model.addAttribute("userId", "lee");
		model.addAttribute("userName", "이순신");
		
		return "test/result";
	}
}

package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
@RequestMapping("/test")
public class MainController {

	/*
		method = RequestMethod.GET
			- 이 메소드를 GET 방식으로 요청했을 때만 실행하도록 설정
	*/
	@RequestMapping(value = "/main1.do", method = RequestMethod.GET)
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("msg", "main1");
		modelAndView.setViewName("test/main");

		return modelAndView;
	}

	@RequestMapping(value = "/main2.do", method = RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("msg", "main2");
		modelAndView.setViewName("test/main");

		return modelAndView;
	}
}

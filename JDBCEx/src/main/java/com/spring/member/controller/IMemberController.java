package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface IMemberController {

	public ModelAndView openMemberListView(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String openMemberRegistView(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView processMemberRegist(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView openMemberUpdateView(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String processMemberUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView processMemberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

package com.company.hello.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.company.hello.member.vo.MemberVO;

public interface IMemberController {

	public ModelAndView openMemberListView(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String openMemberRegistView(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String processMemberRegist(HttpServletRequest request, HttpServletResponse response, MemberVO member) throws Exception;
	public ModelAndView openMemberUpdateView(HttpServletRequest request, HttpServletResponse response, String id) throws Exception;
	public String processMemberUpdate(HttpServletRequest request, HttpServletResponse response, MemberVO member) throws Exception;
	public String processMemberDelete(HttpServletRequest request, HttpServletResponse response, String id) throws Exception;
	public ModelAndView openMemberLoginView(HttpServletRequest request, HttpServletResponse response, String id) throws Exception;
}

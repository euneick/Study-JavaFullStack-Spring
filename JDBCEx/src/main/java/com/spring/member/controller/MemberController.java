package com.spring.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberController extends MultiActionController implements IMemberController {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) { this.memberService = memberService; }

	@Override
	public ModelAndView openMemberListView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<MemberVO> memberList = memberService.selectMembers();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("memberList", memberList);
		
		modelAndView.setViewName("members/list");
		
		return modelAndView;
	}

	@Override
	public String openMemberRegistView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processMemberRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView openMemberUpdateView(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processMemberUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView processMemberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		memberService.deleteMember(request.getParameter("id"));
		
		return openMemberListView(request, response);
	}

}

package com.spring.member.controller;

import java.util.ArrayList;
import java.util.List;

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

		request.setCharacterEncoding("utf-8");

		List<MemberVO> memberList = memberService.selectMembers();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("memberList", memberList);
		
		modelAndView.setViewName("member/list");
		
		return modelAndView;
	}

	@Override
	public String openMemberRegistView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "member/regist";
	}

	@Override
	public String processMemberRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		memberService.insertMember(request);
		
		return "redirect:/Member/list.do";
	}

	@Override
	public ModelAndView openMemberUpdateView(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		request.setCharacterEncoding("utf-8");
		
		MemberVO member = memberService.selectMember(request);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("member", member);
		
		modelAndView.setViewName("member/update");
		
		return modelAndView;
	}

	@Override
	public String processMemberUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		memberService.updateMember(request);
		
		return "redirect:/Member/list.do";
	}

	@Override
	public String processMemberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		memberService.deleteMember(request);
		
		return "redirect:/Member/list.do";
	}

}

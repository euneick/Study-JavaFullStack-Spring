package com.company.hello.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.company.hello.member.service.MemberService;
import com.company.hello.member.vo.MemberVO;

@Controller("memberController")
public class MemberController implements IMemberController {

	// id가 memberService인 빈을 자동으로 주입
	@Autowired
	private MemberService memberService;

	@Override
	@RequestMapping(value = "/Member/list.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView openMemberListView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		List<MemberVO> memberList = memberService.selectMembers();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("memberList", memberList);
		
		modelAndView.setViewName("member/list");
		
		return modelAndView;
	}

	@Override
	@RequestMapping(value = "/Member/regist.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String openMemberRegistView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "member/regist";
	}

	@Override
	@RequestMapping(value = "/Member/registPro.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String processMemberRegist(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("member") MemberVO member) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		memberService.insertMember(member);
		
		return "redirect:/Member/list.do";
	}

	@Override
	@RequestMapping(value = "/Member/update.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView openMemberUpdateView(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") String id) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		MemberVO member = memberService.selectMember(id);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("member", member);
		
		modelAndView.setViewName("member/update");
		
		return modelAndView;
	}

	@Override
	@RequestMapping(value = "/Member/updatePro.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String processMemberUpdate(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("member") MemberVO member) throws Exception {

		request.setCharacterEncoding("utf-8");

		memberService.updateMember(member);
		
		return "redirect:/Member/list.do";
	}

	@Override
	@RequestMapping(value = "/Member/deletePro.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String processMemberDelete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") String id) throws Exception {

		request.setCharacterEncoding("utf-8");

		memberService.deleteMember(id);
		
		return "redirect:/Member/list.do";
	}

}

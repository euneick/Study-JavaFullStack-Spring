package com.spring.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController extends MultiActionController {

	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView sendMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {

		accountService.sendMoney();

//		ModelAndView modelAndView = new ModelAndView();		
//		modelAndView.setViewName("account/result");		
//		return modelAndView;
		
		return new ModelAndView("account/result");
	}
}

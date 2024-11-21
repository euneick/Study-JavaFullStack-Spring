package com.spring.account;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController extends MultiActionController {

	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
}

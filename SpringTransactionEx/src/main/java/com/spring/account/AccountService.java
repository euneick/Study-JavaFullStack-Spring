package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 	트랜잭션 처리를 위한 어노테이션
 	Service클래스의 모든 메소드에 트랜잭션 기능을 적용시킴
 	 * propagation 				- 트랜잭션 전파 규칙 설정
 	 * Propagation.REQUIRED		- 트랜잭션 필요, 진행 중인 트랜잭션이 있는 경우 해당 트랜잭션 적용, 없으면 새로운 트랜잭션 생성, 디폴트 값
 */
@Transactional(propagation = Propagation.REQUIRED)
public class AccountService {

	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	
}

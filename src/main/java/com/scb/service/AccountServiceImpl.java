package com.scb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.entity.Account;
import com.scb.repository.AccountRepository;
import com.scb.util.GenerateAccountNumber;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	public Account createAccount(Integer custId) {
		Account account = new Account();
		account.setCustId(custId);
		account.setAcctNo(GenerateAccountNumber.generateAcctNumber());
		account.setBalance(10000f);
		
		return accountRepository.save(account);
	}

}

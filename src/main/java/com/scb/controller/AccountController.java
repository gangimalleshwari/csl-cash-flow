package com.scb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.entity.Account;
import com.scb.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	private static final Logger logger = LogManager.getLogger(AccountController.class);
	@PostMapping("/create/{custId}")
	public ResponseEntity<Integer> createAccount(@PathVariable(value = "custId") Integer custId){
		logger.debug("custId in accountService", custId);;
		Account account = accountService.createAccount(custId);
		Integer acctId = null;
		if (account!=null) {
			acctId = account.getAcctId();
		}
		return new ResponseEntity<Integer>(acctId,HttpStatus.CREATED);
	}
	
	
}

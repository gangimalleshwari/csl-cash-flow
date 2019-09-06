package com.scb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.dto.PaymentDto;
import com.scb.entity.Account;
import com.scb.entity.Payment;
import com.scb.repository.AccountRepository;
import com.scb.repository.PaymentRepository;
import com.scb.util.TransactionType;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	public String createPayment(PaymentDto payDto) {
		 Payment debitPaymentDetails = null;
		 Payment creditPaymentDetails = null;
		 if(payDto!=null) {
			 Account debitAcct= accountRepository.findByAcctNumber(payDto.getDebitAcct());
			 Account payeeAccount = accountRepository.findByAcctNumber(payDto.getPayeeAcct());
			if (debitAcct != null) {
				Float withdrawlAmt = debitAcct.getBalance() - payDto.getDebitAmt();
				Float depositAmt = payeeAccount.getBalance() + payDto.getDebitAmt();
				if (withdrawlAmt != null) {
					debitAcct.setBalance(withdrawlAmt);
					accountRepository.save(debitAcct);
				}
				payeeAccount.setBalance(depositAmt);
				accountRepository.save(payeeAccount);
			}
		  debitPaymentDetails = paymentRepository.save(saveDebitDetails(payDto));
	      creditPaymentDetails = paymentRepository.save(saveCreditDetails(payDto));
	      if (debitPaymentDetails!=null && creditPaymentDetails!=null) 
	    	  return "Transaction Details Saved Successfully";
		}
		
		return null;
	}

	public static Payment saveDebitDetails(PaymentDto payDto) {
		Payment payment = null;
		if (payDto!=null) {
			payment = new Payment();
			payment.setAcctNo(payDto.getDebitAcct());
			payment.setCreatedDate(payDto.getCreatedDate());
			payment.setType(TransactionType.DEBIT);
			payment.setTxAmt(payDto.getDebitAmt());
			
		}
		return payment;
	}
	
	public static Payment saveCreditDetails(PaymentDto payDto) {
		Payment payment = null;
		if (payDto!=null) {
			payment = new Payment();
			payment.setAcctNo(payDto.getPayeeAcct());
			payment.setCreatedDate(payDto.getCreatedDate());
			payment.setType(TransactionType.CREDIT);
			payment.setTxAmt(payDto.getDebitAmt());
		}
		return payment;
	}

	@Override
	public List<Payment> getTransactionDetails(Integer acctNo) {
		if(acctNo!=null)
		return paymentRepository.getTransactionDetails(acctNo);
		return null;
	}
}

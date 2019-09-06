package com.scb.service;

import java.util.List;

import com.scb.dto.PaymentDto;
import com.scb.entity.Payment;

public interface PaymentService {
	public String createPayment(PaymentDto payDto);
	public List<Payment> getTransactionDetails(Integer acctNo);
}

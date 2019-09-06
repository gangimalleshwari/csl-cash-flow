package com.scb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.dto.PaymentDto;
import com.scb.entity.Payment;
import com.scb.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
@Autowired	
private PaymentService paymentService;

@PostMapping("/create")	
public ResponseEntity<String> createPayment(@RequestBody PaymentDto payDto) {
		return new ResponseEntity<String>(paymentService.createPayment(payDto),HttpStatus.CREATED);
	}


@GetMapping("/transhistory")
public ResponseEntity<List<Payment>> getTransactionDetails(@RequestParam Integer acctNo){
	return new ResponseEntity<List<Payment>>(paymentService.getTransactionDetails(acctNo),HttpStatus.CREATED);
}


}

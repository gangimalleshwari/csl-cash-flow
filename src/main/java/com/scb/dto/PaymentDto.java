package com.scb.dto;

import java.io.Serializable;
import java.util.Date;

public class PaymentDto implements Serializable{
	
	private Integer debitAcct;
	private Integer payeeAcct;
	private Float debitAmt;
	private Date createdDate;
	public PaymentDto() {
		super();
	}
	public PaymentDto(Integer debitAcct, Integer payeeAcct, Float debitAmt, Date createdDate) {
		super();
		this.debitAcct = debitAcct;
		this.payeeAcct = payeeAcct;
		this.debitAmt = debitAmt;
		this.createdDate = createdDate;
	}
	public Integer getDebitAcct() {
		return debitAcct;
	}
	public void setDebitAcct(Integer debitAcct) {
		this.debitAcct = debitAcct;
	}
	public Integer getPayeeAcct() {
		return payeeAcct;
	}
	public void setPayeeAcct(Integer payeeAcct) {
		this.payeeAcct = payeeAcct;
	}
	public Float getDebitAmt() {
		return debitAmt;
	}
	public void setDebitAmt(Float debitAmt) {
		this.debitAmt = debitAmt;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}

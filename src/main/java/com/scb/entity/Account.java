package com.scb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="account")
@Entity
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acct_id")
	private Integer acctId;
	@Column(name = "cust_id")
	private Integer custId;
	@Column(name = "acct_no")
	private Integer acctNo;
	@Column(name = "acct_bal")
	private Float balance;
	@Override
	
	public String toString() {
		return "Account []";
	}
	
	
	public Account() {
		super();
	}


	public Account(Integer acctId, Integer custId, Integer acctNo, Float balance) {
		super();
		this.acctId = acctId;
		this.custId = custId;
		this.acctNo = acctNo;
		this.balance = balance;
	}
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package com.scb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.scb.util.TransactionType;

@Entity
@Table(name="pymt_trans")
public class Payment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "acct_no")
	private Integer acctNo;
	
	@Column(name="tx_amt")
	private Float txAmt;
	
	@Column(name="createddate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	@Enumerated(EnumType.STRING)
    private TransactionType type;
	
	
	public Payment() {
		super();
	}


	public Payment(Integer id, Integer acctNo, Float txAmt, Date createdDate, TransactionType type) {
		super();
		this.id = id;
		this.acctNo = acctNo;
		this.txAmt = txAmt;
		this.createdDate = createdDate;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAcctNo() {
		return acctNo;
	}


	public void setAcctNo(Integer acctNo) {
		this.acctNo = acctNo;
	}


	public Float getTxAmt() {
		return txAmt;
	}


	public void setTxAmt(Float txAmt) {
		this.txAmt = txAmt;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public TransactionType getType() {
		return type;
	}


	public void setType(TransactionType type) {
		this.type = type;
	}


	
	
}

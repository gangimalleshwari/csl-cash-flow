package com.scb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scb.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query(value="SELECT * FROM cash_flow.pymt_trans where acct_no=:acctNo order by createddate asc",nativeQuery = true)
	List<Payment> getTransactionDetails(@Param("acctNo") Integer acctNo);
}

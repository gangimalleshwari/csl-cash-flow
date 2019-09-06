package com.scb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scb.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("from Account where acctNo=:acctNo")
	public Account findByAcctNumber(@Param("acctNo") Integer acctNo);
	
	@Query(value="update account set acct_bal=:balance where acct_no=:acctNo",nativeQuery=true)
	public void updateBalanceByAccountNo(@Param("balance") Float balance,@Param("acctNo")Integer acctNo);

}

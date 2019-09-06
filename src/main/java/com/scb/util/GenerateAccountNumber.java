package com.scb.util;

public class GenerateAccountNumber {
	
	public static int generateAcctNumber() {
		
		return (int)((Math.random() * 9000000)+1000000); 
		
	}

}

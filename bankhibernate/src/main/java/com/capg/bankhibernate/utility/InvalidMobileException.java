package com.capg.bankhibernate.utility;

public class InvalidMobileException extends Exception {
	  public InvalidMobileException() {
		  System.out.println("mobile number already exists");
	  }

}

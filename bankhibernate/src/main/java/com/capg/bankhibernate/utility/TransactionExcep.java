package com.capg.bankhibernate.utility;

public class TransactionExcep extends Exception {
    public  TransactionExcep() {
    	System.out.println("transaction failed");
    }
}

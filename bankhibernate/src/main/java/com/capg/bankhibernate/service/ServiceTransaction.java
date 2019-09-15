package com.capg.bankhibernate.service;

import com.capg.bankhibernate.ui.Customer;
import com.capg.bankhibernate.ui.TransationPojo;

public interface ServiceTransaction {
	Customer deposit(Customer customer);
    Customer withDraw(Customer customer);
    Customer showBalance(Customer customer);
 
       TransationPojo fundTransfer(TransationPojo tp);
}

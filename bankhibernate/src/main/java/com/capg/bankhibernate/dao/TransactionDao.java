package com.capg.bankhibernate.dao;

import com.capg.bankhibernate.ui.Customer;
import com.capg.bankhibernate.ui.TransationPojo;

public interface TransactionDao {
	 Customer deposit(Customer customer);
     Customer withDraw(Customer customer);
   Customer showBalance(Customer customer);
    TransationPojo fundTransfer(TransationPojo transaction1);
}

package com.capg.bankhibernate.ui;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction_Details")
public class TransationPojo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  long transactionid;
     private long fromaccount;
     private long toaccount;
     private long amounttransferred;
     
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	
	public long getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(long fromaccount) {
		this.fromaccount = fromaccount;
	}
	public long getToaccount() {
		return toaccount;
	}
	public void setToaccount(long toaccount) {
		this.toaccount = toaccount;
	}
	public long getAmounttransferred() {
		return amounttransferred;
	}
	public void setAmounttransferred(long amounttransferred) {
		this.amounttransferred = amounttransferred;
	}
     
}

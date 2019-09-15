package com.capg.bankhibernate.driver;

import java.util.Scanner;

import com.capg.bankhibernate.service.Service;
import com.capg.bankhibernate.service.ServiceTransaction;
import com.capg.bankhibernate.serviceImpl.ServiceImpl;
import com.capg.bankhibernate.serviceImpl.ServiceTransactionImpl;
import com.capg.bankhibernate.ui.Customer;
import com.capg.bankhibernate.ui.TransationPojo;
import com.capg.bankhibernate.utility.InvalidMobileException;
import com.capg.bankhibernate.utility.TransactionExcep;
import com.capg.bankhibernate.utility.custom;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	       Service s = new ServiceImpl();
	       ServiceTransaction st = new ServiceTransactionImpl();
	       Customer customer = new Customer();
	       TransationPojo tp = new TransationPojo();
	       Customer c1 = new Customer();
	     
	       System.out.println("enter the choice");
	       System.out.println("1.Registration");
	       System.out.println("2.login");
	       int ch = sc.nextInt();
	       switch(ch) {
	       case 1 :
	    	   System.out.println("enter the first name");
	      	   customer.setFirstname(sc.next());
	      	   System.out.println("enter the last name");
	      	   customer.setLastname(sc.next());
	      	   System.out.println("enter email");
	      	   customer.setEmail(sc.next());
	      	   System.out.println("enter password");
	      	   customer.setPassword(sc.next());
	      	   System.out.println("enter pan number");
	      	   customer.setPanNo(sc.next());
	      	   System.out.println("enter aadhar num");
	         	customer.setAadharCardNo(sc.next());
	         	 if( s.isAadharNoCorrect( customer.getAadharCardNo() ))
	         	  {
	         		 System.out.println("enter address");
	           	   customer.setAddress(sc.next());
	           	   System.out.println("enter the mobile num");
	           	   customer.setMobileNo(sc.next());
	           	   if(s.isMobileNoCorrect(customer.getMobileNo())) {
	           		      int accNo = s.registration(customer);
	                	       System.out.println("Registration succesful");
	                	       System.out.println("your account Number is " + accNo);
	           	   }
	           	   else
	           	   {
	           		   try {
	           			   throw new InvalidMobileException();
	           		   }catch(InvalidMobileException e) {};
	           	   }
	           	    
	         	 
	         	  }
	         	  else {
	         		  try {
	         			  throw new custom();
	         		  }catch(custom e) {};
	         	  }
	        	 
	        	    
	      	 
	      	
	      		  
	      	  
	    	       
	    	  break;
	       case 2 :
	    	   System.out.println("enter the account number");
	    	   customer.setAccountNo(sc.nextLong());
	    	   System.out.println("password");
	    	   customer.setPassword(sc.next());
	    	    customer = s.login(customer);
	    	   if(customer.getFirstname()!=null){
	    	   
	    	   do
	    	   {
	    		   System.out.println("enter the choice");
	    		   System.out.println("1.withdraw");
	    		   System.out.println("2.deposit");
	    		   System.out.println("3.show balance");
	    		   System.out.println("4.fund transfer");
	    		   int key =sc.nextInt();
	    		   switch(key) {
	    		   case 1:
	    			   System.out.println("enter the amount to be debited");
	    			   customer.setAmount(sc.nextLong());
	    			   customer = st.withDraw(customer);
	    			   System.out.println("Remaining balance: "+customer.getBalance());
						break;
	    		   case 2 :
	    			   System.out.println("enter the amount to be credited");
	    			   customer.setAmount(sc.nextLong());
	    			   Customer customer2 =   st.deposit(customer);
	    			   customer.setBalance(customer2.getBalance());
	    			   System.out.println("updated balance: "+customer.getBalance());
	    			   break;
	    		   case 3 :
	    			   
	    			   customer = st.showBalance(customer);
	    			   System.out.println(" balance: "+customer.getBalance());
	    			   break;
	    		   case 4 :
	    			   System.out.println("enter the source account no");
	    				tp.setFromaccount(sc.nextLong());
	    				System.out.println("enter destination account no");
	    				tp.setToaccount(sc.nextLong());
	    				System.out.println("enter amount to be transferred");
	    				tp.setAmounttransferred(sc.nextLong());
	    				tp = st.fundTransfer(tp);
	    				if (tp != null) {
	    					System.out.println(tp.getAmounttransferred() + " is transferred from "
	    							+ tp.getFromaccount() + " to " + tp.getToaccount());
	    					break;
	    				}
	    				else {
	    					try {
								throw new TransactionExcep();
							} catch (TransactionExcep e) {
								// TODO: handle exception
							}
	    				}
	    		   default:
	    			   System.exit(0);
	    			   
	    		   }
	    	   }while(true);
	    	   
	       }else 
	    	   System.out.println("Invalid account number");
	    	   break;
	       
		} 
	       
	       
	      
	}

}

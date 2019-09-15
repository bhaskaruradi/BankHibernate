package com.capg.bankhibernate.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.capg.bankhibernate.dao.TransactionDao;
import com.capg.bankhibernate.ui.Customer;
import com.capg.bankhibernate.ui.TransationPojo;

public class TransationImpl implements TransactionDao {
	Customer c = new Customer();
	TransationPojo tr = new TransationPojo();
	// ServiceTransaction s = new ServiceTransactionImpl();

	public Customer deposit(Customer customer) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer2 = new Customer();

		customer2 = session.get(Customer.class, customer.getAccountNo());

		long balance = customer.getBalance();

		balance += customer.getAmount();

		customer2.setBalance(balance);

		Query query = session
				.createQuery("update Customer set balance = :balance" + " where accountNo = :accountNo");
		query.setParameter("balance", balance);
		query.setParameter("accountNo", customer.getAccountNo());
		query.executeUpdate();

		transaction.commit();

		return customer2;

	}

	public Customer withDraw(Customer customer) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer2 = new Customer();

		customer2 = session.get(Customer.class, customer.getAccountNo());

		long balance = customer.getBalance();

		balance -= customer.getAmount();

		customer2.setBalance(balance);

		session.update(customer2);
		transaction.commit();

		return customer2;

	}

	public Customer showBalance(Customer customer) {
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
//				
//				ResultSet resultSet;
//				PreparedStatement preparedStatement = connection.prepareStatement("select * from customer_details where acount_no = ?");
//				preparedStatement.setLong(1,customer.getAccountNo());
//				resultSet = preparedStatement.executeQuery();
//				resultSet.next();
//				customer.setBalance(resultSet.getInt(10));
//			
//			}
//			catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		customer = session.get(Customer.class, customer.getAccountNo());
		return customer;

	}

	public TransationPojo fundTransfer(TransationPojo transaction1) {
		long amt = transaction1.getAmounttransferred();
		long fromBal = 0, toBal = 0, fromAcc = 0, toAcc = 0;
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Customer customer = new Customer();
		Customer customer2 = new Customer();
		customer = session.get(Customer.class, transaction1.getFromaccount());
		customer2 = session.get(Customer.class, transaction1.getToaccount());
		if (customer.getBalance() > amt) {
			customer.setBalance(customer.getBalance() - amt);
			customer2.setBalance(customer2.getBalance() + amt);
			fromAcc = customer.getAccountNo();
			toAcc = customer2.getAccountNo();
			fromBal = customer.getBalance();
			toBal = customer2.getBalance();

			transaction.commit();

			transaction1.setAmounttransferred(amt);
			transaction1.setFromaccount(fromAcc);
			transaction1.setToaccount(toAcc);
			Configuration configuration1 = new Configuration().configure().addAnnotatedClass(TransationPojo.class);
			SessionFactory sessionFactory1 = configuration1.buildSessionFactory();
			Session session1 = sessionFactory1.openSession();
			Transaction trans = session1.beginTransaction();
			session1.persist(transaction1);
			trans.commit();
			return transaction1;
		} else {
			return null;
		}

	}

	private int updateBalance(long fromBalance, long fromAccountNo) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI",
					"oracle123");
			PreparedStatement ps = connection
					.prepareStatement("update customer_details set balance = ? where acount_no = ?");
			ps.setLong(1, fromBalance);
			ps.setLong(2, fromAccountNo);
			i = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	private Customer insertAmt(Customer customer) {
		return customer;
//			int i = 0;
//			PreparedStatement ps = null;
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "CAPGEMINI", "oracle123");
//				ps = connection.prepareStatement("insert into transaction_details values(transaction_sequence.nextval,?,?,?)");
//				ps.setLong(1, fromAccountNo);
//				ps.setLong(2, toAccountNo);
//				ps.setLong(3, amount);
//				
//				i = ps.executeUpdate();
//			}  catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			TransationPojo transactionDetails = new TransationPojo();
//			transactionDetails.setFromaccount(customer.getAccountNo());
//			transactionDetails.setToaccount(customer.getAccountNo());
//			transactionDetails.setAmounttransferred(customer.getAmount());
//			Configuration configuration1 = new Configuration().configure().addAnnotatedClass(TransationPojo.class);
//			SessionFactory sessionFactory1 = configuration1.buildSessionFactory();
//			Session session1 = sessionFactory1.openSession();
//			Transaction transaction1 = session1.beginTransaction();
//			session1.save(transactionDetails);
//			transaction1.commit();
//			return customer;
//			
//			}
//				
	}
}

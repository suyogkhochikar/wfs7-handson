package com.org.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.exception.AccountNotFoundException;
import com.org.model.exception.InsufficientBalanceException;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) {
		// TODO Auto-generated method stub
		Account acc= accountDao.getAccount(accountNumber);
		double bal= acc.getBalance(); 
		return bal;
	}

	@Override
	public void transfer(int sourceAccount, int destincationAccount, double amount) throws AccountNotFoundException,InsufficientBalanceException {
	
			Account acc1= accountDao.debit(sourceAccount, amount);
			Account acc2= accountDao.credit(destincationAccount, amount);	

	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
 		.sorted((account1, account2) -> (int)account1.getBalance()-(int)account2.getBalance())
		.collect(Collectors.toList());
		
		return sortedAccount;
		
	}

}

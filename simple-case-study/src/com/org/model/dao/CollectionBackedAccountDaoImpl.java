package com.org.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.org.model.beans.Account;

public class CollectionBackedAccountDaoImpl implements AccountDao {

	private static List<Account> database = new ArrayList<>();
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		return account;
	}



	@Override
	public Account getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		for(Account acc: database) {
			if(acc.getAccountNumber()==accountNumber) {
				return acc;
			}
			
				
		}
		return null;
	}

	@Override
	public List<Account> getAccounts() {
		// TODO Auto-generated method stub
		return database;
	}

	@Override
	public Account debit(int accountNumber, double amount) {
		for(Account acc: database) {
			if(acc.getAccountNumber()==accountNumber) {	
				acc.setBalance(acc.getBalance()-amount);
				return acc;
			}
		}
		return null;
	}

	@Override
	public Account credit(int accountNumber, double amount) {
		// TODO Auto-generated method stub
		for(Account acc: database) {
			if(acc.getAccountNumber()==accountNumber) {
				acc.setBalance(acc.getBalance()+amount);
				return acc;
			}
		}
		return null;
	}

	@Override
	public void deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub
		for(Account acc: database) {
			if(acc.getAccountNumber()==accountNumber) {
				database.remove(acc);
			}
		
	}

}
}

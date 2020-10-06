package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.exception.AccountNotFoundException;
import com.org.model.exception.InsufficientBalanceException;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountDao accService=ObjectFactory.getAccountDaoInstance(); 
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account 2: Check Balance");
			System.out.println("3: Transfer Amount 4: Sort Accounts by name 5: Sort Accounts by account number 6:Delete account 0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name");
				Account account = new Account(scanner.next());
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				break;
			case 2:
					System.out.println("Enter acc number to check balance");
					double abal= service.getBalance(scanner.nextInt());
					System.out.println("Your accout balance is: " + abal);
					break;
					
					
			case 3: 
					System.out.println("Enter your account number");
					int sourceAccount=scanner.nextInt();
					System.out.println("Enter destination account number");
					int destinationAccount=scanner.nextInt();
					System.out.println("Enter amount to be transferred");
					double amount= scanner.nextDouble();
				try {
					service.transfer(sourceAccount, destinationAccount, amount);
				} catch (AccountNotFoundException | InsufficientBalanceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
					break; 
			
			case 4: 
				list = service.getAccountsSortedByName(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
			case 5:
				list = service.getAccountsSortedByAccountNumber(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
				
			case 6:
				System.out.println("Enter account number to delete account:");
				accService.deleteAccount(scanner.nextInt()); 
				break;
				
			case 0:	
				break;
			}
		} while(option != 0);
		
		scanner.close();
	}

}


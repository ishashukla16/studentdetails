package com.capgemini.services;
import com.capgemini.beans.*;
import com.capgemini.exceptions.*;
import java.util.LinkedList;
public class HDFCBank implements BankInterface {
 private LinkedList<Account> accounts=new LinkedList<>();
	public String createAccount(int accountNumber,int amount) throws InsufficientOpeningAccountBalanceException
	{
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		if(account.getAmount()>=500)
		{
		accounts.add(account);
		return "account created successfully";
		}else
		throw new InsufficientOpeningAccountBalanceException();
	}
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException
	{
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber,int amount) throws InsufficientBalanceException , InvalidAccountNumberException
	{
Account account=searchAccount(accountNumber);
		synchronized(account)
		{
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}
	}
	
	
public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException {
	Account account=searchAccount(accountNumber);
	
		account.setAmount(account.getAmount()+amount);
		return account.getAmount(); 	
}
public int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws InvalidAccountNumberException,InsufficientBalanceException {
	{
		Account accountSender=searchAccount(accountNumber1);
		Account accountReceiver=searchAccount(accountNumber2);
		if((accountSender.getAmount()-amount)>=0)
		{
			//int[] accountno= {account1.getAmount()-amount,account2.getAmount()+amount};
			accountSender.setAmount(accountSender.getAmount()-amount);
			accountReceiver.setAmount(accountReceiver.getAmount()+amount);
			int[] amounts= {accountSender.getAmount(),accountReceiver.getAmount()};
			return amounts;
		}
	}
	throw new InsufficientBalanceException();
}
}


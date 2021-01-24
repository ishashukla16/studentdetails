package com.capgemini.services;

import com.capgemini.exceptions.*;

import com.capgemini.beans.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.test.AccountTest;

public class AccountServiceImpl implements AccountService {
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	
	AccountRepository accountRepository;
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public Account createAccount(int accountNumber,int amount) throws InsufficientOpeningAccountBalanceException
	{
		if(amount<500)
		{
			throw new InsufficientOpeningAccountBalanceException();
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		
		account.setAmount(amount);
		 
		if(accountRepository.save(account))
		{
			return account;
		}
	     
		return account;
		
	}
	@Override
	public Account depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {

		if(accountRepository.searchAccount(accountNumber)!= AccountTest.account)
		{
			throw new InvalidAccountNumberException();
		}
		AccountTest.account.setAmount(AccountTest.account.getAmount()+amount);
		return AccountTest.account;
	}

	@Override
	public Account withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException, InsufficientAmountException {
		
		if(accountRepository.searchAccount(accountNumber) != AccountTest.account)
		{
			throw new InvalidAccountNumberException();
		}
		if(AccountTest.account.getAmount()-amount<0) 
		{
			throw new InsufficientAmountException();
		}
		AccountTest.account.setAmount(AccountTest.account.getAmount()-amount);
		
		return AccountTest.account;
	}	


	/*private Account searchAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return null;*/
	}

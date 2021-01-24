package com.capgemini.services;

import com.capgemini.exceptions.InsufficientOpeningAccountBalanceException;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InsufficientAmountException;
public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientOpeningAccountBalanceException;
	Account depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException;
	Account withdrawAmount(int accountNumber, int amount) throws InvalidAccountNumberException,InsufficientAmountException;
}

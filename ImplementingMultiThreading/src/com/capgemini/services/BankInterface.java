package com.capgemini.services;
import com.capgemini.exceptions.*;
public interface BankInterface {
	String createAccount(int accountNumber,int amount) throws InsufficientOpeningAccountBalanceException;
	int withdrawAmount(int accountNumber,int amount) throws InsufficientBalanceException , InvalidAccountNumberException;
	int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;
	int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws InvalidAccountNumberException , InsufficientBalanceException;
}

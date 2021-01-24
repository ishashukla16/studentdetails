package com.capgemini.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientOpeningAccountBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InsufficientAmountException;
import com.capgemini.beans.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.services.AccountService;
import com.capgemini.services.AccountServiceImpl;


public class AccountTest {

	AccountService accountService;
	public static Account account = new Account();		
	@Mock
	AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		accountService = new AccountServiceImpl(accountRepository);
	}
	
	
	@Test(expected=com.capgemini.exceptions.InsufficientOpeningAccountBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientOpeningAccountBalanceException
	{
		accountService.createAccount(101, 400);
	}
	
	@Test
	public void whenTheInformationIsCorrectAccountCreatedSuccessfully() throws InsufficientOpeningAccountBalanceException
	{
		account =new Account(101,5000);
		when(accountRepository.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}
	
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenTheAccountNumberIsInvalidDuringDepositSystemShouldThrowException() throws InvalidAccountNumberException,InsufficientOpeningAccountBalanceException
	{
		accountService.depositAmount(101, 2000);
	}
	@Test
	public void whenTheInformationIsCorrectAmountShouldDeposite() throws InvalidAccountNumberException, InsufficientAmountException,InsufficientOpeningAccountBalanceException
	{	
		account = new Account(101,600);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		assertEquals(account, accountService.depositAmount(101, 5000));
	}
	@Test(expected=com.capgemini.exceptions.InvalidAccountNumberException.class)
	public void whenTheAccountNumberIsIncorrectDuringWithdrawingShouldThrowException() throws InvalidAccountNumberException, InsufficientAmountException, InsufficientOpeningAccountBalanceException
	{
		accountService.withdrawAmount(100, 2000);
	}
	@Test(expected=com.capgemini.exceptions.InsufficientAmountException.class)
	public void whenTheAmountWithdrawnIsMoreThanPresentBalanceSystemShouldThrowException() throws InvalidAccountNumberException, InsufficientAmountException, InsufficientOpeningAccountBalanceException
	{
		account = new Account(101,700);
		when(accountRepository.searchAccount(101)).thenReturn(account);
		accountService.withdrawAmount(101, 800);
	}
	@Test
	public void whenTheInformationIsCorrectAmountShouldBeWithdrawn() throws InvalidAccountNumberException, InsufficientAmountException,InsufficientOpeningAccountBalanceException
	{
		account = new Account(102, 600);
		when(accountRepository.searchAccount(102)).thenReturn(account);
		assertEquals(account, accountService.withdrawAmount(102, 300));
	}
}







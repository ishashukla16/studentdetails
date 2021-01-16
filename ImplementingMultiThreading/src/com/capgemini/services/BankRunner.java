package com.capgemini.services;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
public class BankRunner implements Runnable {

	HDFCBank bank;
	
	public BankRunner(HDFCBank bank)
	{
		this.bank=bank;
	}
	@Override
	public void run() {
			try
		{
			if(Thread.currentThread().getName().equals("first"))
			{
			System.out.println("Balance = "+bank.withdrawAmount(101, 2000));
			}
			else
			{
				System.out.println("Balance = "+bank.withdrawAmount(102, 2000));
			}
		}catch(InvalidAccountNumberException i)
		{
			System.out.println("invalid account number");
		}catch(InsufficientBalanceException j)
		{
			System.out.println("Insufficient balance");
		}
		{
			
		}

	}

}

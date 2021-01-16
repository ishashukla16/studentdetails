package com.capgemini.users;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningAccountBalanceException;
import com.capgemini.services.*;
public class Client {
     
	public static void main(String[] args) {
		 HDFCBank bank=new HDFCBank();
		 BankRunner bankRunner=new BankRunner(bank);
		try {
			System.out.println("creating account");
			System.out.println(bank.createAccount(101,5000));
			System.out.println(bank.createAccount(102,10000));
			Thread firstThread=new Thread(bankRunner,"first");
			firstThread.start();
			
			Thread secondThread=new Thread(bankRunner,"first");
			secondThread.start();
		
			System.out.println("deposit amount");
			System.out.println("amount in account no 102 is : "+bank.depositAmount(102,7000));
			System.out.println("fund transfer");
			int []amounts=bank.fundTransfer(101, 102, 2000);
			System.out.println("present balance of account number 101: "+amounts[0]+"  present balance of account number 102 : "+amounts[1]);
		}catch(InsufficientBalanceException inb) {
			System.out.println("insufficient balance to perform fund transfer operation");
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}catch(InsufficientOpeningAccountBalanceException ins) {
			System.out.println("Insuuficient amount for opening an account....minimum required balance must be 500");
		}
	}
}


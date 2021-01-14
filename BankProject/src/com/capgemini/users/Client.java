package com.capgemini.users;
import com.capgemini.exceptions.*;
import com.capgemini.services.*;
public class Client {
     
	public static void main(String[] args) {
		 BankInterface bank=new HDFCBank();
		try {
			System.out.println("creating account");
			System.out.println(bank.createAccount(101,5000));
			System.out.println(bank.createAccount(102,10000));
		}catch(InsufficientOpeningAccountBalanceException ins) {
			System.out.println("Insuuficient amount for account opening....minimum balance must be 500");
		}
		try {
			System.out.println("withdrawing amount");
			System.out.println("Balance of account no 101 is: "+bank.withdrawAmount(101, 5000));
		}catch(InsufficientBalanceException inb) {
			System.out.println("insufficient balance");
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}
		try {
			System.out.println("deposit amount");
			System.out.println("amount in account no 102 is : "+bank.depositAmount(102,7000));
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}
		try {
			System.out.println("fund transfer");
			int []a=bank.fundTransfer(101, 102, 2000);
			System.out.println("new balance of account number 101: "+a[0]+"  New balance of account number 102 : "+a[1]);
		}catch(InsufficientBalanceException inb) {
			System.out.println("insufficient balance");
		}catch(InvalidAccountNumberException ina) {
			System.out.println("invalid account number");
		}
	}

}

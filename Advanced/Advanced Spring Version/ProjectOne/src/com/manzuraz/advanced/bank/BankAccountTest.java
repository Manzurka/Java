package com.manzuraz.advanced.bank;

public class BankAccountTest {
	 public static void main(String args[]) {
		BankAccount account1 =  new BankAccount();
		account1.checkingAccount();
		BankAccount account2 =  new BankAccount();
		account2.savingsAccount();
		account1.DepositToChecking(300);
		account2.DepositToSavings(200);
		System.out.println(BankAccount.seeTotalBalance());
		System.out.println(BankAccount.accountsCount());
	 }
}

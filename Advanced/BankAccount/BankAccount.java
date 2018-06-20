import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int NumOfAccounts;
	private static double Money;
	
	private void setAccountNum() {
		StringBuilder Number = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 10; i++) {
	    	Number.append(random.nextInt(9));
	    }
	    accountNumber =  Number.toString();
	}
	
	public void checkingAccount() {
		setAccountNum();
		checkingBalance = 0;
		NumOfAccounts++;
		System.out.println("Checking account was opened with account number of " + this.accountNumber);
	}
	
	public void savingsAccount() {
		setAccountNum();
		savingsBalance = 0;
		NumOfAccounts++;
		System.out.println("Savings account was opened with account number of " + this.accountNumber);
	}
	

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void DepositToChecking(double money) {
		setCheckingBalance(money);
		Money += money;
	}
	
	public void DepositToSavings(double money) {
		setSavingsBalance(money);
		Money += money;
	}
	
	public static double seeTotalBalance() {
		return Money;
	}
	
	public static int accountsCount() {
		return NumOfAccounts;
	}
}
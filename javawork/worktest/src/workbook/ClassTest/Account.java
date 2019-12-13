package workbook.ClassTest;

public class Account {
	private String account;
	private int balance;
	private double interestRate;

	public Account() {

	}

	public Account(String account, int balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		double interest = this.balance * this.interestRate / 100;
		return interest;
	}

	public void print() {
		System.out.println("계좌번호:" + getAccount() + " 잔액:" + getBalance() + " 이자율:" + getInterestRate()+"%");
	}
	public void accountInfo() {
		System.out.println("계좌번호:" + getAccount() + " 잔액:" + getBalance() + " 이자율:" + getInterestRate()+"% 이자 :"
				+calculateInterest()+"원");
	}
}

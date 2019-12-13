package workbook;

public class AccountTest {

	public static void main(String[] args) {
		Account s1 = new Account();
		s1.setAccount("441-0290-1203");
		s1.setBalance(500000);
		s1.setInterestRate(7.3);

		s1.print();
		s1.deposit(20000);
		s1.print();
		
		
		double interest = s1.calculateInterest();
		
		System.out.println(+interest);
	}

}

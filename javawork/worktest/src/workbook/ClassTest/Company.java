package workbook.ClassTest;

public class Company {
	private double salary;		//기본급
	//double Sum = 0.0;			
	double bonus = 0.0;			//보너스
	double annualIncome = 0.0;  	//연소득
	double afterTaxIncome = 0.0;	//세금 공제 후 연소득의 합
	double afterTaxBonus = 0.0;		//세금 공제 후 연 보너스의 합

	public Company() {
	}

	public Company(double salary) {
		this.salary = salary;
	}


	public double getBonus() {
		for (int i = 1; i <= 12; i++) {
			if (i % 3 == 0) {
				bonus = bonus + this.salary * 0.2;
			} else {
			}
		}
		return bonus;
	}

	public double getIncome() {
		annualIncome= this.salary * 12;
		return annualIncome;
	}

	public double getAfterTaxIncome() {
		//afterTaxIncome = annualIncome - annualIncome * 0.1; ->오류 날 가능성 농후
		afterTaxIncome = getIncome()-(getIncome()*0.1);
		return afterTaxIncome;
	}	

	public double getAfterTaxBonus() {
		double afterTaxBonus = bonus - bonus * 0.055;
		return afterTaxBonus;
	}

}

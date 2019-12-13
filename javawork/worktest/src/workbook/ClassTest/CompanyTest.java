package workbook.ClassTest;

public class CompanyTest {

	public static void main(String[] args) {
		//Coxmpany의 salary가 double이고 입력받은 salary가 int이므로 자동 casting.
		int salary = Integer.parseInt(args[0]);
		Company comp = new Company(salary);
		
		
		System.out.println("연 기본급 합 : "+comp.getIncome()+" 세후:"+comp.getAfterTaxIncome());
		System.out.println("연 보너스 합 : "+comp.getBonus()+" 세후:"+comp.getAfterTaxBonus());
		System.out.println("연 지급액의 합: "+(comp.getAfterTaxIncome()+comp.getAfterTaxBonus()));

	}	

}

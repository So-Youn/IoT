package workbook.poly.Animal;
public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Chicken cheatableChicken = new Chicken(5);
		
		if(cheatableChicken instanceof Chicken){
			cheatableChicken.fly();
		}
		for(int i=1;i<=3;i++) {
			dog.run(i);
			chicken.run(i);
			cheatableChicken.run(i);
			System.out.println(i+"�ð���");
			System.out.println("���� �̵��Ÿ� :"+dog.getDistance());
			System.out.println("���� �̵��Ÿ� :"+chicken.getDistance());
			System.out.println("������ ���� �̵��Ÿ�:"+cheatableChicken.getDistance());
		}
	}
	
}














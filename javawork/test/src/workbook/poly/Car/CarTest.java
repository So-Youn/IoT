package workbook.poly.Car;



public class CarTest {
	public static void main(String[] args) {
		Car[] car = new Car[2];
		car[0] = new L3("L3","1500",50,25,0);
		car[1] = new L5("L5","2000",75,35,0);
		Car.print();
		for (int i = 0; i < car.length; i++) {
			if(car[i] instanceof L3) {
			System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
					+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L3)car[i]).getTempGage());
			}else {
				System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
						+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L5)car[i]).getTempGage());
			}
		}
	
		
		System.out.println("25주유");
		Car.print();
		for (int i = 0; i < car.length; i++) {
			car[i].setOil(25);
			if(car[i] instanceof L3) {
				System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
						+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L3)car[i]).getTempGage());
				}else {
					System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
							+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L5)car[i]).getTempGage());
				}
			}
		System.out.println("80주행");
	
		Car.print();
		for (int i = 0; i < car.length; i++) {
			car[i].go(80);
			if(car[i] instanceof L3) {
				System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
						+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L3)car[i]).getTempGage());
				}else {
					System.out.println(car[i].getName()+"\t\t"+car[i].getEngine()+"\t  "+car[i].getOilTank()+"\t    "
							+car[i].getOilSize()+"\t\t"+car[i].getDistance()+"\t"+((L5)car[i]).getTempGage());
				}
			}
	}
	
}

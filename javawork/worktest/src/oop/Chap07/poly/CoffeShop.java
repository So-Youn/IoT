package oop.Chap07.poly;

public class CoffeShop {
	public static void main(String[] args) {
		System.out.println("****java nara CoffeeShop영업개시****");
		Beverage[] beverage = new Beverage[5];
		beverage[0] = new Coffee("Cappuccino");			//coffee가 beverage 상속
		beverage[1] = new Coffee("CafeLatte");
		beverage[2] = new Tea("ginsengTea");
		beverage[3] = new Coffee("CafeLatte");
		beverage[4] = new Tea("redginsengTea");
		getSalesInfo(beverage);
		System.out.println("총 판매 금액==>" + getTotalPrice(beverage));
		System.out.println("Coffe의 판매 개수=>" + Coffee.amount + "잔");
		System.out.println("Tea의 판매 개수=>" + Tea.amount + "잔");
	}

	public static void getSalesInfo(Beverage[] beverage) {
		for (int i = 0; i < beverage.length; i++) {
			//beverage[i].calcPrice();
			System.out.print((i+1) + "번째 ");
			beverage[i].print();
		}
	}

	public static int getTotalPrice(Beverage[] beverage) {	//static 메소드에서 그냥 호출만 하고있기 때문에
		int price = 0;
		for (int i = 0; i < beverage.length; i++) {
			price = price + beverage[i].getPrice();//beverage의 객체가 저장된 getPrice()호출.

		}
		return price;
	}

}

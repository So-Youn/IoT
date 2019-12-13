package oop.Chap07.poly;

public class Tea extends Beverage{
	static int amount;		//모든 객체가 공통으로 갖는 값
	
	public Tea() {
		
	}
	public Tea(String name) {
		super(name);
		amount++;
	}
	
	@Override
		public void calcPrice() {
			if(getName().equals("lemonTea")) {
				setPrice(1500);
			}else if(getName().equals("ginsengTea")) {
				setPrice(2000);
			}else if(getName().equals("redginsengTea")) {
				setPrice(2500);
			}
	}

	
}

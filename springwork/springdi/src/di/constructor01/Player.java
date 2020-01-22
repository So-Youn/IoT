package di.constructor01;
//player가 갖고있는 Dice를 외부조립기(스프링컨테이너)Injection 받아 사용해야 하므로 Injection받을 수 있도록 미리 준비해야 한다.
// => Constructor or Setter메소드
public class Player implements AbstractPlayer {
	//상속받았기 때문에 상위타입으로 만 들어준다. 모든 하위가 교체된다고 하더라도 적용될 수 있도록
	AbstractDice d;
	int totalValue=0;
	
	public Player(AbstractDice d) {
		super();
		this.d = d;
	}
	
	public void play(){
		totalValue=0;
		for (int i = 0; i < 3; i++) {
			totalValue+=d.getDiceValue();
		}
	}
	public int getTotalValue(){
		return totalValue;
	}
}
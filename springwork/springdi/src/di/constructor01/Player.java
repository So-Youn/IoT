package di.constructor01;
//player�� �����ִ� Dice�� �ܺ�������(�����������̳�)Injection �޾� ����ؾ� �ϹǷ� Injection���� �� �ֵ��� �̸� �غ��ؾ� �Ѵ�.
// => Constructor or Setter�޼ҵ�
public class Player implements AbstractPlayer {
	//��ӹ޾ұ� ������ ����Ÿ������ �� ����ش�. ��� ������ ��ü�ȴٰ� �ϴ��� ����� �� �ֵ���
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
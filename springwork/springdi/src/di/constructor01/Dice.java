package di.constructor01;

import java.util.Random;

public class Dice extends Random implements AbstractDice {
	public int getDiceValue() {
		return nextInt(6) + 1;	//1~6까지 주사위 굴리기
	}
}

package exam.anno01;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service   // Service클래스 내부에서 알아서 bean객체를 만들어 준다.
public class Dice2 extends Random implements AbstractDice{
	public int getDiceValue(){
		return nextInt(6)+100; //100~105까지의 랜덤 수
	}
}

package exam.anno01;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service   // ServiceŬ���� ���ο��� �˾Ƽ� bean��ü�� ����� �ش�.
public class Dice2 extends Random implements AbstractDice{
	public int getDiceValue(){
		return nextInt(6)+100; //100~105������ ���� ��
	}
}

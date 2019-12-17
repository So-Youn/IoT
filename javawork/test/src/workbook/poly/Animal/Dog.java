package workbook.poly.Animal;

public class Dog extends Animal implements Cheatable {
	public Dog() {

	}

	public Dog(int speed) {
		super(speed);
	}

	@Override
	public void run(int hours) {
		setDistance(getDistance() * (hours/2));

	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

}

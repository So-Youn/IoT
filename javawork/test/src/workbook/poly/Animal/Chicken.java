package workbook.poly.Animal;

class Chicken extends Animal implements Cheatable {
	double distance;
	public Chicken() {

	}

	public Chicken(int speed) {
		super(speed);

	}

	@Override
	public void run(int hours) {
		setDistance(getSpeed() * hours);
	}



	@Override
	public void fly() {
		setSpeed(getSpeed()*2);

	}

	

}

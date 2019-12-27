package workbook.poly.Animal;

class Dog extends Animal {
	double distance;
	public Dog() {

	}

	public Dog(int speed) {
		super(speed);
	}

	@Override
	public void run(int hours) {
		setDistance((getSpeed() * hours)/2);

	}



}

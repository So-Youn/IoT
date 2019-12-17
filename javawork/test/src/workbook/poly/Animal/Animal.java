package workbook.poly.Animal;

public abstract class Animal {
	private int speed;
	double distance;
	public Animal() {
		
	}
	public Animal(int speed) {
		super();
		this.speed=speed;
		
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public abstract void run(int hours);
	
	
}

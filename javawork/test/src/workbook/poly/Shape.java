package workbook.poly;

public abstract class Shape {
	Protected Point point;
	public shape() {
		
	}
	public shape(Point point) {
		this.point=point;
	}
	public abstract double getArea();
	public abstract double getCircumfrerence();
}

package workbook.poly.point;

public abstract class Shape {
	protected Point point;
	public Shape() {
		
	}
	public Shape(Point point) {
		this.point=point;
	}
	public abstract double getArea();
	public abstract double getCircumference();
	
}
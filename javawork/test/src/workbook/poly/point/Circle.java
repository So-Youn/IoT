package workbook.poly.point;

public class Circle extends Shape implements Movable{
	private int radius;
	public Circle() {
		
	}
	public Circle(int x, int y,int radius) {
		super(new Point(x,y));		//has a 관계(상속이 아님)
		this.radius=radius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return (double)(Math.PI*radius*radius);
	}

	@Override
	public void move(int x, int y) {
		point.setX(point.getX()+x+1);
		point.setY(point.getY()+y+1);
	}
	@Override
	public double getCircumference() {
		return (double)(2*Math.PI*radius);
	}
	
}

package workbook.poly.point;

public class Rectangle extends Shape implements Movable{
	private int width;	
	public Rectangle() {
		
	}
	public Rectangle(int x,int y,int width) {
		super(new Point(x,y));
		this.width=width;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public double getArea() {
		return width*width;
	}
	@Override
	public void move(int x, int y) {
		point.setX(point.getX()+x+2);
		point.setY(point.getY()+y+2);
	}
	@Override
	public double getCircumference() {
		return (double)(2*(width+width));
	}

	
}
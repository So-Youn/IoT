package workbook.poly.shape;

public class Rectangle extends Shape implements Resize {
	public Rectangle() {

	}
	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
	}

	@Override
	public double getArea() {
		double area = (double)(getWidth() * getHeight());
		return area;
	}

	@Override
	public void setResize(int size) {
		setWidth(getWidth() +size);
	}
}

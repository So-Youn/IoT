package workbook.poly.point;

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shape = new Shape[4];
		shape[0] = new Rectangle(7, 5, 4);
		shape[1] = new Rectangle(4, 6, 5);
		shape[2] = new Circle(6, 7, 6);
		shape[3] = new Circle(8, 3, 7);
		String name = "";
		for (int i = 0; i < shape.length; i++) {

			if (shape[i] instanceof Rectangle) {
				name = "Rectangle";
				System.out.print(name +":"+ ((Rectangle) shape[i]).getWidth() +" "+
						((Rectangle)shape[i]).point.getX()+" "+((Rectangle)shape[i]).point.getY());
			} else {
				name = "Circle";
				System.out.print(name +":"+ ((Circle) shape[i]).getRadius() +" "+
						((Circle)shape[i]).point.getX()+" "+((Circle)shape[i]).point.getY());
			}
			System.out.println( );
		}
		System.out.println("After Move....");

		for (int i = 0; i < shape.length; i++) {
			if (shape[i] instanceof Rectangle) {
				name = "Rectangle";
				((Rectangle)shape[i]).move(10,10);
				System.out.print(name +":"+ ((Rectangle) shape[i]).getWidth() +" "+
						((Rectangle)shape[i]).point.getX()+" "+((Rectangle)shape[i]).point.getY());
			} else {
				name = "Circle";
				((Circle)shape[i]).move(10,10);
				System.out.print(name +":"+ ((Circle) shape[i]).getRadius() +" "+
						((Circle)shape[i]).point.getX()+" "+((Circle)shape[i]).point.getY());
			
			}
			System.out.println( );
		}
	}

}

package workbook.poly.shape;

public class ShapeTest {
	public static void main(String[] args) {
		// ShapeŸ���� ��ü�� ������ �� �ִ� ����6���� ������ ����
		Shape[] shape = new Shape[7];
		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4, 6, "Blue");
		shape[2] = new Triangle(6, 7, "Red");
		shape[3] = new Rectangle(8, 3, "Red");
		shape[4] = new Triangle(9, 8, "White");
		shape[5] = new Rectangle(5, 7, "White");
		shape[6] = new Circle(0, 0, "White", 5);
		System.out.println("�⺻����");
		String name = "";
		for (int i = 0; i < shape.length; i++) {
			if (shape[i] instanceof Triangle) {
				name = "Triangle";

			} else if (shape[i] instanceof Rectangle) {
				name = "Rectangle";
			} else {
				name = "Circle"; // �޼ҵ�ȭ �غ���1!!
			}
			System.out.print(name + shape[i].getArea() + "\t" + shape[i].getColors());
			System.out.println();
		}
		// ���� for�� - 5.0���� �߰��� for��
		// �迭�̳� collection�� �ٷ� �� ���.
		// for���� �ѹ� ����� ������ shape �迭���� ��� �ϳ��� ������ obj�� ���� �� �۾�.
		for (Shape obj : shape) { // for (����Ÿ�� �����̸� : �迭�̸�)
			System.out.println(obj.getColors());// obj = shape[i]
			// ��ü�� Ÿ���� �����ϴ� ���� ������ �����ϴ� ���� �ƴ϶�,
			// ��ü�� Ÿ���� üũ�� �Ŀ� �����Ѵ�.
	
		System.out.println("����� ���� �� ����");
		for (int i = 0; i < shape.length; i++) {
			
			if (shape[i] instanceof Triangle) {
				((Triangle) shape[i]).setResize(5);
				name = "Triangle";
			} else if (shape[i] instanceof Rectangle){
				((Rectangle) shape[i]).setResize(5);
				name = "Rectangle";
			} else {
				name = "Circle";
			}
			System.out.print(name+"\t"+ shape[i].getArea() + "\t" + shape[i].getColors());
			System.out.println();
		}
		}
	}
}

package workbook.poly.shape;

public class ShapeTest {
	public static void main(String[] args) {
		// Shape타입의 객체를 참조할 수 있는 변수6개를 변수로 생성
		Shape[] shape = new Shape[7];
		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4, 6, "Blue");
		shape[2] = new Triangle(6, 7, "Red");
		shape[3] = new Rectangle(8, 3, "Red");
		shape[4] = new Triangle(9, 8, "White");
		shape[5] = new Rectangle(5, 7, "White");
		shape[6] = new Circle(0, 0, "White", 5);
		System.out.println("기본정보");
		String name = "";
		for (int i = 0; i < shape.length; i++) {
			if (shape[i] instanceof Triangle) {
				name = "Triangle";

			} else if (shape[i] instanceof Rectangle) {
				name = "Rectangle";
			} else {
				name = "Circle"; // 메소드화 해보기1!!
			}
			System.out.print(name + shape[i].getArea() + "\t" + shape[i].getColors());
			System.out.println();
		}
		// 향상된 for문 - 5.0부터 추가된 for문
		// 배열이나 collection을 다룰 때 사용.
		// for문이 한번 실행될 때마다 shape 배열에서 요소 하나씩 꺼내서 obj에 전달 후 작업.
		for (Shape obj : shape) { // for (변수타입 변수이름 : 배열이름)
			System.out.println(obj.getColors());// obj = shape[i]
			// 객체의 타입을 변경하는 경우는 무조건 변경하는 것이 아니라,
			// 객체의 타입을 체크한 후에 변경한다.
	
		System.out.println("사이즈를 변경 후 정보");
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

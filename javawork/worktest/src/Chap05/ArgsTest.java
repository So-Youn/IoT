package Chap05;

public class ArgsTest {

	public static void main(String[] args) {
		/*
		 *		args = new String[2];
		 *						명령형 매개변수의 갯수만큼 설정
		 *		args[0] = "100"
		 *		args[1] = "200"
		 */		
		System.out.println("명령은 매개변수 ->"+args[0]);
		System.out.println("명령은 매개변수 ->"+args[1]); // 0,1 2개 입력받음
		
		for (int i=0; i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println("합=>"+(args[0]+args[1]));  		//String이기 때문에 계산이 되지 않고, 100, 200으로 출력
		
	//	int num1 = args[0]; 		//int =  String x
		int num1 = Integer.parseInt(args[0]);	//String을 매개변수로 전달
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("합=>"+ (num1+num2)); 
	}

}

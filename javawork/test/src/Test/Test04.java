package Test;
//������ ���� ch�� ������ (�빮�� �Ǵ� �ҹ���) �� ���� ���� b�� ���� true�� �ǵ��� �ϼ��ض�.
public class Test04 {

	public static void main(String[] args) {
		char ch = '��';
		boolean b = ('a' <= ch && ch <='z') || ('A' <= ch) && (ch<='Z');
		System.out.println(b);
		
		
	}

}

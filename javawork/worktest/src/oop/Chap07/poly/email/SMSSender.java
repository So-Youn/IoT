package oop.Chap07.poly.email;
public class SMSSender extends Sender {
	int length;
	public SMSSender(String name,int length){
		super(name);
		this.length = length;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void print() {
		//SMSSender로만 처리되는 고유의 기능 실행
		System.out.println(length+"로"+name+"전송 완료.");
	}
	
}

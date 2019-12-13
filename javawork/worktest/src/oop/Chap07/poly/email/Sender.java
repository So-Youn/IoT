package oop.Chap07.poly.email;
public abstract class Sender {
	String name;
	Sender(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void print(); //print가 하는 일이 없으므로 print 가 있다는 것만 명시
	
}


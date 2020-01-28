package book.exam.setter;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() { //기본 생성자
		System.out.println("AppleSpeaker객체생성");
	}
	public void soundUp() {
		System.out.println("AppleSpeaker의 볼륨업~~~~");
	}
	public void soundDown() {
		System.out.println("AppleSpeaker의 볼륨다운~~~~");
	}
}

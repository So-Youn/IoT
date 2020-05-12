package basic;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;

public class SerialConnectionTest {
	public SerialConnectionTest(){
		
	}
	public void connect(String portName){
		try {
			//COM포트가 실제 존재하고 사용가능한 상태인지 확인
			CommPortIdentifier comportIdentifier = 
					CommPortIdentifier.getPortIdentifier(portName);
			if(comportIdentifier.isCurrentlyOwned()){
				System.out.println("포트 사용할 수 없습니다 ");
			}else{
				System.out.println("포트 사용 가능");
				//port가 사용 가능하면 포트 열고 포트 객체 얻어오기
				//매개변수 1 : 포트를 열고 사용하는 프로그램의 이름(문자열)
				//매개변수2 : 포트를 열고 통신하기 위해 기다리는 시간(밀리세컨드)
				CommPort commPort = comportIdentifier.open("basic_serial",3000);
				System.out.println(commPort);
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new SerialConnectionTest().connect("COM10");
	}

}

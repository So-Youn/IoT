package can;

import java.io.BufferedInputStream;
import java.io.IOException;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
//시리얼포트를 통해서 데이터가 전송되었을 때 실행되는 클래스. 전송되서 들어오는 데이터를 읽는 역할만 함
public class SerialListener implements SerialPortEventListener {
	BufferedInputStream bis;//캔통신으로 input되는 데이터를 읽기 위해 오픈된
	public SerialListener(BufferedInputStream bis) {
		this.bis = bis;
	}
	//데이터가 전송될 때마다 호출되는 메소드
	@Override
	public void serialEvent(SerialPortEvent event) {
		switch(event.getEventType()) {
		//DATA_AVAILABLE => 데이터가 도착하면 어떤거를 하겠다는 의미
			case SerialPortEvent.DATA_AVAILABLE:
				byte[] readBuffer = new byte[128];
			try {
				while(bis.available()>0) {//데이터 전체를 읽기
					int numbyte = bis.read(readBuffer);//읽은 내용이 readBuffer에 셋팅됨
				}
				String data = new String(readBuffer);
				System.out.println("Can시리얼 포트로 전송된데이터=>"+data);
				//전송되는 메시지를 검사해서 적절하게 다른 장치를 제어하거나 Car클라이언트 객체로 전달해서 서버로 전송되도록 처리
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

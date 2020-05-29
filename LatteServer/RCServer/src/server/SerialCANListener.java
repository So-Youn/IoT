package server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialCANListener implements SerialPortEventListener{
	BufferedInputStream bis;//캔통신으로 input되는 데이터를 읽기 위해 오픈된
	OutputStream os;
	String msg;
	PrintWriter pw;
	AndroidClient androidClient;
	String speed;
	String hexmessage;
	String result;
	String fromMaster;
	String fromSlave;
	public SerialCANListener(BufferedInputStream bis) {
		this.bis = bis;
	//	serialClient = new SerialClient();
		//System.out.println("캔리스너 포트 불러오는 곳");
		msg = "";
		//내가 추가한 부분(아두이노의 데이터를 받기위한 작업)
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
				msg = data;
				
				System.out.println("msg래요~~~~~ "+ msg);
				if(msg.trim().startsWith(":W2800000001")){
					fromMaster = msg.trim();
					System.out.println("Master가 Can시리얼 포트로 전송한데이터=>"+fromMaster);
				}else if(msg.trim().startsWith(":U2800000002")){
					fromSlave = msg.trim();
					System.out.println("Slave가 Can시리얼 포트로 전송한데이터=>"+fromSlave);
				}
				//전송되는 메시지를 검사해서 적절하게 다른 장치를 제어하거나 Car클라이언트 객체로 전달해서 서버로 전송되도록 처리
				//캔으로 수신된 데이터가 0000000000000011이면 LED끄기
				//캔으로 수신된 데이터가 0000000000000000이면 LED켜기
				/*
				 * 1. 아두이노와 시리얼통신을 할 수 있도록 OUTPUT스트림얻기
				 *    => 생성자에서 한 번 작업할 수 있도록 처리
				 * 2. OUTPUT스트림으로 '0','1'내보내기             
				 * 	   => CAN으로 수신된 데이터를 비교해서 
				 * 		  :U2800000000000000003F*/
				                 
				
					
					if(msg.trim().equals(fromSlave)) {
						result = getHexToDec(msg);
						System.out.println("slave에서 보내온 데이터 "+result);
						androidClient.sendMessage("speed/"+result);
					}else {
						System.out.println("u28 에러");
						//os.write('0');
					}
				
				
				//내가 추가한 부분.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public String getMessage() {
		System.out.println("노예 캔으로부터 받는 중"+msg);
		//String newMsg = "";
		switch (msg) {
		case ":U2800000001000000000000005045":
			
			break;

		default:
			break;
		}
		return msg;
	}
	public String getHexToDec(String hex){
		long v = 0;
		String str = "";
		String data = hex.substring(12,28);
		//Long.parseLong(hex.substring(12,14),16);
		
		System.out.println("num ::::"+data);
		String hexdata = String.valueOf(Integer.parseInt(data)).trim();
		System.out.println(hexdata);
		for(int i = 0;i<=hexdata.length()-2;i+=2){
			int start = i;
			int end = i+2;
			v = Long.parseLong(hexdata.substring(start,end),16);
			System.out.println("Long변환"+(char)v);
			
			str = str + String.valueOf((char)v);
			System.out.println("중간 결과 : " + str);
		}
		
		return str;
	}
}

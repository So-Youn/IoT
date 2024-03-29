package controlCarClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ClientCar {
	Socket socket;
	
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	
	OutputStream os;
	PrintWriter pw;
	
	StringTokenizer st;
	String carId;
	
	CANReadWriteTest canReadWriteTest;
	public static void main(String[] args) {
		new ClientCar().connect();
	}
	public void connect() {
		try {
			socket = new Socket("70.12.227.61", 12345);
			System.out.println("접속 성공!!!");
			if(socket!=null) {
				carId="11111";
				ioWork();
				
				//CAN통신 열기
				canReadWriteTest = new CANReadWriteTest("COM6");
			}
			Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                    String msg;
	                    try {
	                        msg = br.readLine();
	                        System.out.println("서버로 부터 수신된 메시지>>"
	                                + msg);
	                        filteringMsg(msg);
	                    } catch (IOException e) {
	                        try {
	                            //2. 서버쪽에서 연결이 끊어지는 경우 사용자는 자원을 반납======
	                            //자원반납
	                            is.close();
	                            isr.close();
	                            br.close();
	                            os.close();
	                            pw.close();
	                            socket.close();
	                          
	
	                        } catch (IOException e1) {
	                            // TODO Auto-generated catch block
	                            e1.printStackTrace();
	                        }
	                        break;//반복문 빠져나가도록 설정
	                    }
	                }
	            }
	        });
	        t1.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void filteringMsg(String msg) {
		System.out.println("클라이언트가 받은 메시지"+msg);
		st = new StringTokenizer(msg, ":");
		String protocol = st.nextToken();
		//app에게 받은 메시지 수행!!
		if(protocol.equals("job")) {
			String message = st.nextToken();
			if(message.equals("engineStart")) {
				String id = "00000000";//송신할 메시지의 구분 id
				String data = "0000000000000000";//송신할 데이터 -> 내 마음대로 정해주기, 16글자는 맞춰야함
				String mesaage = id+data;
				canReadWriteTest.send(mesaage);
			}
		}
	}
	
	public void ioWork() {
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			os = socket.getOutputStream();
			pw = new PrintWriter(os, true);
			pw.println("car:"+carId);
			pw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

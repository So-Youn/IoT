package basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//키보드로 입력하는 값을 아두이노로 내보내기 위한 쓰레드 - Serial 통신
public class SerialLEDArduinoWriterThread extends Thread {
	OutputStream out;
	InputStream is;
	ServerSocket socket;

	public SerialLEDArduinoWriterThread(OutputStream out) {
		super();
		this.out = out;
	}

	public void run() {
		int ledstate = 0;
		try {
			socket = new ServerSocket(5000);
			Socket acceptsocket = socket.accept();
			System.out.println(acceptsocket.getInetAddress().getHostAddress());
			is = acceptsocket.getInputStream();
			while (true) { // 입력받는 값이 없을 대의 리턴값 :
				ledstate = is.read();
				out.write(ledstate);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}

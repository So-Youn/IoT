package chat.step07.exam;
/*

  	
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class User extends Thread {

	Socket client;
	ChatServerView serverView;
	
	InputStream is;
	InputStreamReader ir;
	BufferedReader br;

	OutputStream os;
	PrintWriter pw;
	
	String nickname;
	//3. User객체에 기존 사용자의 정보를 액세스할 수 있도록 변수 정의=========
	Vector<User> userlist;
	//========================================================
	public User() {
		
	}
	//4. 서버가 접속한 클라이언트의 정보를 User객체로 만들 때 접속한
	//user의 소켓 객체와 서버뷰,userlist전달
	public User(Socket client, ChatServerView serverView,Vector<User> userlist) {
		super();
		this.client = client;
		this.serverView = serverView;
		this.userlist = userlist;
		iowork();
	}
	
	public void iowork() {
		
		try {
			is = client.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);

			os = client.getOutputStream();
			pw = new PrintWriter(os, true);
			//nickname 읽어 서버창에 전송
			nickname = br.readLine();
			System.out.println("nickname:" + nickname);
			serverView.taclientlist.append("******************" + nickname + "님이 입장");
			//2. 기존 for문을 메소드 호출문으로 변경
			broadCast("new/"+nickname);
			//==================================================
			
			//3. 새로운 접속자(this)에게 기존 클라이언트의 정보를 알려주기
			int size = userlist.size(); // 기존 접속자 인원수
			for(int i=0;i<size;i++) {
				User user = userlist.get(i);
				sendMsg("old/"+user.nickname); //이미 접속한 사용자들한테 안내 - 새로접속한 사용자의 
											   // nickname을 보낸다
			}
			userlist.add(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//1. 기존 사용자에게 메시지를 보내는 메소드를 정의
	private void broadCast(String msg) {
		//기존 클라이언트에게 새로운 접속자가 있음을 알려주는 부분
		int size = userlist.size(); // 기존 접속자 인원수
		for(int i=0;i<size;i++) {
			User user = userlist.get(i);
			user.sendMsg("new/"+nickname); //이미 접속한 사용자들한테 안내 - 새로접속한 사용자의 
										   // nickname을 보낸다
		}
	}
	//=======================================================================
	public void sendMsg(String message) {
		pw.println(message);
	}
	
	public void run() {
		while(true) { //데이터 읽기
			try {
				String msg = br.readLine(); 
				serverView.taclientlist.append( nickname + "님이 전송한 메시지 :"+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	
}

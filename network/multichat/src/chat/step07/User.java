package chat.step07;
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
			//6.새로운 클라이언트가 입장을 하면 벡터에 저장되어 있는 
			//모든 클라이언트에게 입장을 알리는 메시지를 보낸다.
			int size = userlist.size(); // 기존 접속자 인원수 
			for(int i=0;i<size;i++) {
				User user = userlist.get(i);
				user.sendMsg("new/"+nickname); //이미 접속한 사용자들한테 안내 - 새로접속한 사용자의 
											   // nickname을 보낸다
				}
			
			// userlsit 에는 기존 사용자밖에 없기 때문에 저장해야한다.
			//8. 접속자 리스트에 현재 새로 접속한 클라이언트 정보도 저장================
			userlist.add(this);
			//===========================================================
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//7.클라이언트에게 메시지를 보내는 메소드를 정의 ========================
	public void sendMsg(String message) {
		pw.println(message);
	}
	//==========================================================
	
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

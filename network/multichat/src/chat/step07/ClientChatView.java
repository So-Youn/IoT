package chat.step07;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientChatView extends JFrame {

	JPanel contentPane;
	JTextField txtinput;
	JTextArea taChat;
	JButton btnsend;
	JList lstconnect;
	String ip;
	int port;
	String nickname;
	Socket socket;
	InputStream is;
	InputStreamReader ir;
	BufferedReader br;

	OutputStream os;
	PrintWriter pw;
	
	//2. 채팅하는 사용자들의 목록을 JList에 추가 (nickname)하기 위한 변수
	Vector<String> nicknamelist = new Vector<>();
	StringTokenizer st;
	//=====================================================
	
	public ClientChatView(String ip, int port, String nickname) {
		this.ip = ip;
		this.port = port;
		this.nickname = nickname;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		taChat = new JTextArea();
		taChat.setBounds(12, 10, 501, 375);
		contentPane.add(taChat);

		txtinput = new JTextField();
		txtinput.setBounds(12, 395, 378, 35);
		contentPane.add(txtinput);
		txtinput.setColumns(10);

		btnsend = new JButton("\uC11C\uBC84\uB85C\uC804\uC1A1");
		btnsend.setFont(new Font("HY견고딕", Font.BOLD, 14));
		btnsend.setBounds(402, 395, 109, 35);
		contentPane.add(btnsend);

		JLabel lblNewLabel = new JLabel("\uC811\uC18D\uC790:");
		lblNewLabel.setFont(new Font("HY견고딕", Font.BOLD, 14));
		lblNewLabel.setBounds(519, 10, 120, 35);
		contentPane.add(lblNewLabel);

		lstconnect = new JList();
		lstconnect.setBounds(525, 47, 205, 108);
		contentPane.add(lstconnect);
		//접속한 사용자의 정보가 nicknamelist에 저장되어 있고, 그 벡터를 JList에 출력
		lstconnect.setListData(nicknamelist);
		
		setVisible(true);
		ClientChatListener listener = new ClientChatListener(this);
		txtinput.addActionListener(listener);
		btnsend.addActionListener(listener);
		connectServer();

	}

	public void connectServer() {
		try {

			socket = new Socket(ip, port);
			if (socket != null) {
				iowork();
			}
			//서버한테 nickname전송
			sendMsg(nickname);
			nicknamelist.add(nickname);
			
			Thread recieveThread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) { // 서버가 보낸 데이터를 계속 읽어줄 것
						String msg = "";
						try {
							msg = br.readLine();
							System.out.println("서버가 전달한 메시지>>>" + msg);
							//10. 서버에서 전달된 메시지를 분석하는 메소드 ======
							filtering(msg);
							//=======================================
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			});
			recieveThread.start();

			// taChat.append(msg+"\n");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//9. 서버가 보내오는 데이터를 분석해서 처리하는 메소드를 정의 =======================
	private void filtering(String msg) {
		st = new StringTokenizer(msg,"/"); //msg 를 "/" 기준으로 분리
		String protocol = st.nextToken(); 
		//어떤 작업을 했는 지를 알 수 있는 keyword - new, old, chatting...
		String message = st.nextToken();
		System.out.println("프로토콜 : "+protocol+",메시지:"+message);
		if(protocol.equals("new")) {
			//새로운 사용자가 접속하면 호출되는 부분
			//nicknamelist에 추가
			nicknamelist.add(message);
			//벡터에 데이터를 새로고침
			lstconnect.setListData(nicknamelist);
			//클라이언트 창에 메시지 출력
			taChat.append("******************"+message+"님이 입장하셨습니다.\n");
		}
	}
	//====================================================================
	public void iowork() {
		try {

			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);

			os = socket.getOutputStream();
			pw = new PrintWriter(os, true);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendMsg(String message) {
		System.out.println("클라이언트가 서버에게 메시지 전송하기" + message);
		pw.println(message); 
	}
}

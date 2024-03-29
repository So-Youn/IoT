package chat.step07.exam;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ChatLoginListener  implements ActionListener{
	ChatLogin view; //이벤트를 발생시키는 화면 - chatLogin
	String nickname;
	public ChatLoginListener(ChatLogin view) {
		super();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {  //OnClick 메서드
		
		if(e.getSource()==view.btnConnect){
			nickname = view.txtId.getText().trim();
			if(nickname.isEmpty()) {
				JOptionPane.showMessageDialog(view,
						"대화명을 입력하세요", "대화명오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String ip = view.cboServer.getSelectedItem()+"";
			int port = Integer.parseInt(view.cboPort.getSelectedItem()+"");
			System.out.println(ip+port);
			
			ClientChatView client = new ClientChatView(ip,port,nickname);
			view.dispose();//로그인창을 닫는다.
			
		}
		
	}
}
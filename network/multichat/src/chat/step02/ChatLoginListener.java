package chat.step02;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

//ActionListener 버튼 클릭 시 발생하는 리스너
public class ChatLoginListener  implements ActionListener{
	ChatLogin view; //이벤트를 발생시키는 화면 - chatLogin
	String nickname;
	public ChatLoginListener(ChatLogin view) {
		super();
		this.view = view;
	}
	//Swing에서 버튼이 클릭될 때 호출되는 메서드 
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
		}
	}
}
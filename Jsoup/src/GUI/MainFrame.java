package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	JPanel panel;
	JButton login_bt;

	public void CreateFrame() {
		
		//JFrame 생성
		super.setTitle("Yuhan Login");
		setBounds(400, 300, 400, 400);
		
		//Panel
		panel = new JPanel();
		
		//button
		login_bt = new JButton("Login");
		login_bt.setBounds(100,	100, 170, 170);
		
		panel.setLayout(null);
		panel.add(login_bt);
		add(panel);
		
		login_bt.addActionListener(new ActionListener() {
			
			//익명 클래스
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//버튼 클릭 시, Python REST API 호출
				//API를 통해 사용자를 인증하고 값을 반환
			}
		});
		
		//종료
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

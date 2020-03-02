package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Service.Parsing;

public class Application extends JFrame {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	MyPanel panel;
	JLayeredPane layeredPane;
	JButton total_btn;
	JButton cyber_btn;
	BufferedImage img = null;
	
	public void createFrame() {
	
		
		try {
			img = ImageIO.read(new File("C:\\Users\\sangw\\Face-Recognition\\Application\\img\\yuhan_background.jpg"));
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Application : createFrame() Image Error!!");
		}
		
		//프레임 설정
		super.setTitle("Yuhan Face-Recognition");
		setSize(800, 500);
		centerScreen();
		
		total_btn = new JButton("<html><center>종합 정보<br />로그인</center></html>");
		cyber_btn = new JButton("<html><center>사이버 강의실<br />로그인</center></html>");
		
		//버튼 위치조정
		total_btn.setBounds(100, 100, 270, 250);
		cyber_btn.setBounds(400, 100, 270, 250);
		
		//버튼 폰트설정
		total_btn.setFont(new Font("Courier", Font.BOLD, 30));
		cyber_btn.setFont(new Font("Courier", Font.BOLD, 30));
		
		//버튼 배경색
		total_btn.setBackground(new Color(194, 220, 237));
		cyber_btn.setBackground(new Color(194, 220, 237));
		
		layeredPane = new JLayeredPane();
		layeredPane.setSize(800, 500);
		layeredPane.setLayout(null);
		
		panel = new MyPanel();
		panel.setSize(800, 500);
		layeredPane.add(total_btn);
		layeredPane.add(cyber_btn);
		layeredPane.add(panel);
		setLayout(null);
		
		add(layeredPane);
		

		//버튼 Action
		total_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//프레임 화면 정중앙
	public void centerScreen() {
		
		//Java 화면 크기
		Dimension frameSize = super.getSize();
		
		//모니터 크기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//(모니터화면.가로 - 프레임화면.가로) / 2 , (모니터화면.세로 - 프레임화면.세로) / 2
		super.setLocation((screenSize.width - frameSize.width) / 2 , (screenSize.height - frameSize.height) / 2);
		
	}
	
	class MyPanel extends JPanel {
		
		public void paint(Graphics g) {
			
			g.drawImage(img, 0, 0 , null);
		}
	}
}

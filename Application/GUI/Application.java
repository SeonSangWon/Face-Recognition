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

import org.slf4j.LoggerFactory;

import Database.Connect;
import Service.Parsing;
import Service.RestAPI;

public class Application extends JFrame {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Application.class);
	
	Connect conn;
	MyPanel panel;
	JLayeredPane layeredPane;
	JButton total_btn;
	JButton cyber_btn;
	BufferedImage img = null;
	
	/**
	 * Method ID : createFrame()
	 * Method 설명 : GUI 환경의 Application 호출
	 */
	public void createFrame() {
		
		try {
			img = ImageIO.read(new File("C:\\Users\\sangw\\Face-Recognition\\Application\\img\\yuhan_background.jpg"));
			
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Application : createFrame() Image Error!!");
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
				
				int result = 0;
				String student_id = "";
				String[] infomation = new String[2];
				File filePath = new File("C:\\Python\\face\\faces\\");
				Parsing parser = new Parsing();
				RestAPI api = new RestAPI();
				
				result = api.get("http://127.0.0.1:5000/user/faceRecognition");
				if(result > 0)
				{
					log.debug("Login Success Result = " + result);
					conn = new Connect();
					
					try {
						
						student_id = student_id_Search(result, filePath);
						
						
						Connect.getConnection();
						infomation = conn.getInfomation(student_id);
						
						parser.TotalInfomation(infomation[0], infomation[1]);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
					
				else
					log.error("Login Fail");
			}
		});
		
		cyber_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = 0;
				String student_id = "";
				String[] infomation = new String[2];
				File filePath = new File("C:\\Python\\face\\faces");
				Parsing parser = new Parsing();
				RestAPI api = new RestAPI();
				
				result = api.get("http://127.0.0.1:5000/user/faceRecognition");
				if(result > 0)
				{
					log.debug("Login Success Result = " + result);
					conn = new Connect();
					
					try {
						
						student_id = student_id_Search(result, filePath);
						
						Connect.getConnection();
						infomation = conn.getInfomation(student_id);
						
						parser.CyberRoom(infomation[0], infomation[1]);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
					
				else
					log.error("Login Fail");
			}
		});
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Method ID : centerScreen()
	 * Method 설명 : 화면의 정중앙에 GUI Application을 위치시킨다.
	 */
	public void centerScreen() {
		
		//Java 화면 크기
		Dimension frameSize = super.getSize();
		
		//모니터 크기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//(모니터화면.가로 - 프레임화면.가로) / 2 , (모니터화면.세로 - 프레임화면.세로) / 2
		super.setLocation((screenSize.width - frameSize.width) / 2 , (screenSize.height - frameSize.height) / 2);
		
	}
	
	/**
	 * Method ID : student_id_Search()
	 * Method 설명 : 얼굴인식하는 학생의 학번을 조회
	 * @param result
	 * @param filePath
	 * @return
	 */
	public String student_id_Search(int result, File filePath) {
		
		//C:\Python\face 경로 받아오기
		File[] fileList = filePath.listFiles();
		String img = "";
		String[] split = new String[2];
		
		for(int i=0; i<result; i++)
		{
			img = fileList[i].getName();
		}
		split = img.split("_");
		split[0] = split[0].trim();
		img = split[0];
	
		return img;
	}
	
	class MyPanel extends JPanel {
		
		public void paint(Graphics g) {
			
			g.drawImage(img, 0, 0 , null);
		}
	}
}

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.slf4j.LoggerFactory;

public class Connect {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Connection.class);
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://?serverTimezone=UTC&useSSL=false";
	
	private static final String USER_NAME = "";
	private static final String PASSWORD = "";
	
	/**
	 * Method ID : getConnection()
	 * Method 설명 : 데이터베이스 연결
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			if(conn == null)
			{
				JOptionPane.showMessageDialog(null, "--- [ MySQL Connection Error!!! ] ---", "DataBase Connect Error", 0);
				System.out.println("--- [ MySQL Connection Error!!! ] ---");
				System.exit(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * Method ID : getInfomation()
	 * Method 설명 : 사이트에 로그인하기 위해 ID와 PASSWORD를 조회한다.
	 * @param student_id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String[] getInfomation(String student_id) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		String sql = null;
		String[] result = new String[2];
		try {
			
			conn = getConnection();
			
			sql = "SELECT * FROM member WHERE 1=1 AND student_id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, student_id);
			
			rs = pstat.executeQuery();
			
			rs.next();
			result[0] = rs.getString("id");
			result[1] = rs.getString("password");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

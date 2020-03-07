package Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.slf4j.LoggerFactory;

public class RestAPI {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestAPI.class);
	
	public int get(String strUrl) {
		
		String[] imgCnt = new String[2];
		int result = 0;
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
			
			//con.setConnectTimeout(5000); 									//서버에 연결되는 Timeout 시간 설정
			//con.setReadTimeout(5000); 										// InputStream 읽어 오는 Timeout 시간 설정
			//con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); 	//key값 설정

			con.setRequestMethod("GET");	

            con.setDoOutput(false); 

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) 
			{
				//Stream을 처리해줘야 하는 귀찮음이 있음. 
				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) 
				{
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println("※" + sb.toString());
				imgCnt = sb.toString().split(",");
				imgCnt[1] = imgCnt[1].trim();
				
				result = Integer.parseInt(imgCnt[1]);
				System.out.println("result = " + result);
			} 
			else 
			{
				System.out.println(con.getResponseMessage());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "--- [ REST API Connection ERROR!!! ] ---", "REST API Error", 0);
			JOptionPane.showMessageDialog(null, "--- [ 프로그램을 종료합니다. ] ---", "REST API Error", 0);
			System.exit(0);
		}

		return result;
	}
}

package com.spring.face.Util;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parsing implements IParsing {

	private static final Logger logger = LoggerFactory.getLogger(Parsing.class);
	
	@Override
	public void TotalInfomation(String userId, String password) {
		logger.debug("Paring : TotalInfomation() Run!!!)");

		Runtime runTime = Runtime.getRuntime();
		
		//연결하고자 하는 URL
		String url = "";
		
		//브라우저 설정 값
		String userAgent = "";
		
		url = "https://portal.yuhan.ac.kr/user/loginProcess.face";
		userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
		try{

			Connection.Response loginPageResponse = Jsoup.connect(url)
			        .timeout(3000)
			        .header("Origin", "https://portal.yuhan.ac.kr")
			        .header("Referer", "https://portal.yuhan.ac.kr/user/login.face")
			        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
			        .header("Content-Type", "application/x-www-form-urlencoded")
			        .header("Accept-Encoding", "gzip, deflate, br")
			        .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
			        .method(Connection.Method.GET)
			        .execute();
			
			//로그인 성공 후 얻은 쿠키
			Map<String, String> loginTryCookie = loginPageResponse.cookies();
			System.out.println("loginTryCookie------------: " + loginTryCookie);
			
			//전송할 Form Data
			Map<String, String> data = new HashMap<>();
			data.put("userId", userId);
			data.put("password", password);
			
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() 
			{
				@Override
				public X509Certificate[] getAcceptedIssuers() 
				{
					// TODO Auto-generated method stub
					return new X509Certificate[0];
				}
				
				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException 
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException 
				{
					// TODO Auto-generated method stub
					
				}
			}};
			
			SSLContext sc;
			try {
				sc = SSLContext.getInstance("TLS");
				sc.init(null, trustAllCerts, new SecureRandom());
				
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}catch (KeyManagementException e1) {
				e1.printStackTrace();
			}

			Connection.Response response;
			
			try{
				//로그인 시도
				response = Jsoup.connect(url)
				        .userAgent(userAgent)
				        .timeout(3000)
				        .header("Origin", "https://portal.yuhan.ac.kr")
				        .header("Referer", "https://portal.yuhan.ac.kr/user/login.face")
				        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				        .header("Content-Type", "application/x-www-form-urlencoded")
				        .header("Accept-Encoding", "gzip, deflate, br")
				        .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
				        .cookies(loginTryCookie)
				        .data(data)
				        .method(Connection.Method.POST)
				        .execute();

				//로그인 성공 시, 값 할당
				//로그인 실패 시, NULL
				Map<String, String> loginCookie = new HashMap<>();
				loginCookie = response.cookies();

				System.out.println("Login Check " + loginCookie);
				//웹 페이지 띄우기
				url = url + "?userId=" + userId + "&password=" + password;
				
				runTime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + url);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void CyberRoom(String userId, String password) {
		
		Runtime runTime = Runtime.getRuntime();
		
		//연결하고자 하는 URL
		String url = "";
		
		//브라우저 설정 값
		String userAgent = "";
		
		//Return URL
		String ssoReturn = "";
		
		url = "https://portal.yuhan.ac.kr/user/loginProcess.face";
		userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36";
		ssoReturn = "https://cyber.yuhan.ac.kr/sso_index.jsp";
		try{

			Connection.Response loginPageResponse = Jsoup.connect(url)
			        .timeout(3000)
			        .header("Origin", "https://portal.yuhan.ac.kr")
			        .header("Referer", "https://portal.yuhan.ac.kr/user/login.face")
			        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
			        .header("Content-Type", "application/x-www-form-urlencoded")
			        .header("Accept-Encoding", "gzip, deflate, br")
			        .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
			        .method(Connection.Method.GET)
			        .execute();
			
			//로그인 성공 후 얻은 쿠키
			Map<String, String> loginTryCookie = loginPageResponse.cookies();
			System.out.println("loginTryCookie------------: " + loginTryCookie);
			
			//전송할 Form Data
			Map<String, String> data = new HashMap<>();
			data.put("userId", userId);
			data.put("password", password);
			
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() 
			{
				@Override
				public X509Certificate[] getAcceptedIssuers() 
				{
					// TODO Auto-generated method stub
					return new X509Certificate[0];
				}
				
				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException 
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException 
				{
					// TODO Auto-generated method stub
					
				}
			}};
			
			SSLContext sc;
			try {
				sc = SSLContext.getInstance("TLS");
				sc.init(null, trustAllCerts, new SecureRandom());
				
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}catch (KeyManagementException e1) {
				e1.printStackTrace();
			}

			Connection.Response response;
			
			try{
				//로그인 시도
				response = Jsoup.connect(url)
				        .userAgent(userAgent)
				        .timeout(3000)
				        .header("Origin", "https://portal.yuhan.ac.kr")
				        .header("Referer", "https://portal.yuhan.ac.kr/user/login.face")
				        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
				        .header("Content-Type", "application/x-www-form-urlencoded")
				        .header("Accept-Encoding", "gzip, deflate, br")
				        .header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
				        .cookies(loginTryCookie)
				        .data(data)
				        .method(Connection.Method.POST)
				        .execute();

				//로그인 성공 시, 값 할당
				//로그인 실패 시, NULL
				Map<String, String> loginCookie = new HashMap<>();
				loginCookie = response.cookies();

				System.out.println("Login Check " + loginCookie);
				//웹 페이지 띄우기
				url = "https://cyber.yuhan.ac.kr/sso_index.jsp";
				url = url + "?epTicket=" + loginCookie.get("ENPASSTGC");
				
				runTime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + url);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

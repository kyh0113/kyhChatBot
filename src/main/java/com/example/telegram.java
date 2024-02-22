package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class telegram {
	public static void funcTelegram(){
		String Token = "7185061470:AAGJqrpH3PmLME3o6D_Zvbu8PCJFCILUO3s";
		String chat_id = "5976131197";
		String text = "메시지 전송 테스트" ;
		
		BufferedReader in = null;
		
		 try {
			 URL obj = new URL("https://api.telegram.org/bot" + Token + "/sendmessage?chat_id=" + chat_id + "&text=" + text); // 호출할 url
			 
			 HttpURLConnection con = (HttpURLConnection)obj.openConnection();
			 con.setRequestMethod("GET");
			 in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			 String line;
			 
			 while((line = in.readLine()) != null) { // response를 차례대로 출력
				 System.out.println(line);
			 }		 
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
		 }
	}
}

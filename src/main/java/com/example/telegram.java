package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class telegram {
	public static void funcTelegram(){
		String Token = "7185061470:AAGJqrpH3PmLME3o6D_Zvbu8PCJFCILUO3s";
		String chat_id = "5976131197";
		String text = "안녕? 만나서 반가워. \n 이건 나를 소개하기 위한 챗봇이야~ 즐겁게 나를 소개할게. \n 최종 시험을 통과하면 선물도 있어.";
        
        // 개행 문자를 기준으로 문자열을 나누어 배열에 저장
        String[] lines = text.split("\n");
        
        BufferedReader in = null;
        
        try {
            for (String line : lines) {
                // 각 줄을 URL에 추가하여 호출
                URL obj = new URL("https://api.telegram.org/bot" + Token + "/sendmessage?chat_id=" + chat_id + "&text=" + line);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                con.setRequestMethod("GET");
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String response;
                
                while((response = in.readLine()) != null) { // response를 차례대로 출력
                    System.out.println(response);
                }
            }	 
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
		 }
	}
}

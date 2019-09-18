package net.geekstest.parserdata.ServerConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class GetDatabase {
	public static void main(String[] args) {
		try {
	        String data = "" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode("nameUserXXX", "UTF-8") 
	        + "&" 
	        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode("passXXX", "UTF-8"); 
	        		//("username=" + "nameUserXXX") + "&" + ("password=" + "passXXX");
	        System.out.println(data);
	        
			String url = "https://experimentaldemonstrationxyz.000webhostapp.com/HttpsResponse.php?"
					+ data;//?username=nameUserXXX&password=passXXX
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("GET");
	        httpsURLConnection.setDoOutput(true);
			
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = bufferReader.readLine()) != null) {
				response.append(inputLine);
			}
						
			bufferReader.close();
			
			// Print the response
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}



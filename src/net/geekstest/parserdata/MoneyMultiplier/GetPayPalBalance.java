package net.geekstest.parserdata.MoneyMultiplier;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class GetPayPalBalance {
	public static void main(String[] args) {
		try {
	        String data = "" + URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode("GeeksEmpireInc-facilitator_api1.gmail.com", "UTF-8") 
	        + "&" 
	        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode("AGGDGS6A8XRWV7PL", "UTF-8") 
	        + "&"
	        + URLEncoder.encode("signature", "UTF-8") + "=" + URLEncoder.encode("AW0QnXYwhX9O82JoYqQ6D4KCCi2MAc0Pl0hZZF85hPaaL23JEVOgfH8w", "UTF-8");
	        System.out.println(data);
	        
			String url = "https://experimentaldemonstrationxyz.000webhostapp.com/PayPalGetBalance.php?"
					+ data;//"username=GeeksEmpireInc-facilitator_api1.gmail.com&password=AGGDGS6A8XRWV7PL&signature=AW0QnXYwhX9O82JoYqQ6D4KCCi2MAc0Pl0hZZF85hPaaL23JEVOgfH8w"
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
						
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
			System.out.println(jsonObject);
			System.out.println(jsonObject.get("L_AMT0"));
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}



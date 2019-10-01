package net.geekstest.parserdata.MoneyMultiplier;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;


public class PayPalPayoutAccessToken {
	public static void main(String[] args) {
		try {
			String BasicBase64format = Base64.getEncoder()
					.encodeToString("AV_llcDDdpinvE_Mwe14n6SPW2nTF7-ujLOM6hd8jB508PcyaHfOO0J-bxipwWGFaFbPU4nnO2yRh6JA:EMhsGAX7CkLnvNpDkhidCsWsdd3wCa2gfTnqdWZ77nbKgNMaK_-HXp2za_Cqz0TW7vldcUop5cwI1lO-".getBytes()); 
			
			//curl -v https://api.sandbox.paypal.com/v1/oauth2/token 
			//-H "Accept: application/json" 
			//-H "Accept-Language: en_US" 
			//-u "AV_llcDDdpinvE_Mwe14n6SPW2nTF7-ujLOM6hd8jB508PcyaHfOO0J-bxipwWGFaFbPU4nnO2yRh6JA:EMhsGAX7CkLnvNpDkhidCsWsdd3wCa2gfTnqdWZ77nbKgNMaK_-HXp2za_Cqz0TW7vldcUop5cwI1lO-" 
			//-d "grant_type=client_credentials"
			String url = "https://api.sandbox.paypal.com/v1/oauth2/token";
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("accept", "application/json");
			httpsURLConnection.setRequestProperty("accept-language", "en_US");
			httpsURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			httpsURLConnection.setRequestProperty("authorization", "basic " + BasicBase64format);
			String body = "grant_type=client_credentials";

			// Send request
			httpsURLConnection.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
			dataOutputStream.writeBytes(body);
			dataOutputStream.flush();
			dataOutputStream.close();

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



package net.geekstest.parserdata.MoneyMultiplier;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import net.geekstest.parserdata.JSON.JSONArray;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class PayPalPaymentCreate {
	public static void main(String[] args) {
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("E:\\Xine\\ProjectCode\\Android\\MoneyMultiplier\\PayPalPaymentsAPI\\orderData.json"));
			
			//curl -v -X 
			//POST 
			//https://api.sandbox.paypal.com/v1/payments/payment 
			//-H "Content-Type: application/json" 
			//-H "Authorization: Bearer A21AAHYFSh7ruUtxVXB9e5mZ3FuAZxF7R2MDH5kjaScEmzK0TLuifZQdZw28uybplaL4svHS1kLcyzLkBaNYM2d8hIUuHq-0g" 
			//-d @E:\Xine\ProjectCode\Android\MoneyMultiplier\PayPalPaymentsAPI\payment.json
			
			String accessToken = "A21AAFh8XjnpXyhxy_D2vjIeJr2Gi30aMxTIBH5B1oBt8JKqe4RIYm7e00fAOpsF6osBlu7TAWTg_7qL4Qno3eankj3f52tCg";
			
			String url = "https://api.sandbox.paypal.com/v1/payments/payment";
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("authorization", "Bearer " + accessToken);
			httpsURLConnection.setRequestProperty("content-type", "application/json");
			
			// Send request
			httpsURLConnection.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
			dataOutputStream.writeBytes(jsonObject.toString());
			dataOutputStream.flush();
			dataOutputStream.close();

			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(httpsURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = bufferReader.readLine()) != null) {
				response.append(inputLine);
			}
			bufferReader.close();

			JSONObject jsonObjectApprovalUrl = (JSONObject) jsonParser.parse(response.toString());
			JSONArray urls = (JSONArray) jsonObjectApprovalUrl.get("links");
			JSONObject approvalUrlData = (JSONObject) urls.get(1);//approval_url
			String approvalLink = approvalUrlData.get("href").toString();
			
			// Print the response
			System.out.println(response.toString());
			System.out.println(approvalLink);
			
			openWebpage(URI.create(approvalLink));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
}

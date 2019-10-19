package net.geekstest.parserdata.MoneyMultiplier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class PayPalPaymentValidateInvoice {
	public static void main(String[] args) {
		try {			
			String accessToken = "A21AAHi-7iAqVFoceqEBSIOAaQ1ytvQZTfoxvCB0Zqv1_oWwk3Por5jK-IVOGnxuVo-GSSa-mR6if08rq0L02Rslv6VABBHcA";
			String paymentId = "PAYID-LWTVZOY2NY63161DY9092115";
			
			String url = "https://api.sandbox.paypal.com/v1/payments/payment/" + paymentId;
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setRequestProperty("authorization", "Bearer " + accessToken);
			httpsURLConnection.setRequestProperty("content-type", "application/json");
			
			// Send request
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
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
			
			String isInvoiceValidated = jsonObject.get("state").toString();
			System.out.println(isInvoiceValidated);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

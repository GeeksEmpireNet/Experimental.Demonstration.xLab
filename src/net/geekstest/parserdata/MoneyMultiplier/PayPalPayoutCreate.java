package net.geekstest.parserdata.MoneyMultiplier;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class PayPalPayoutCreate {
	public static void main(String[] args) {
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonArray = (JSONObject) jsonParser.parse(new FileReader("E:\\Xine\\ProjectCode\\Android\\MoneyMultiplier\\PayoutAPI\\data.json"));
			System.out.println(jsonArray.toString());
			
			//curl -X POST https://api.sandbox.paypal.com/v1/payments/payouts 
			//-H "content-type: application/json" 
			//-H "Authorization: Bearer A21AAF2JdzIhPLzOEAe19J9C-gwiUclS457Zi5-3TWZrw91LYYpPtFUFAyb16stnXnbogU39xlGYZQg3hNp7B-ml0Aj0hcE5Q" 
			//-d @E:\Xine\ProjectCode\Android\MoneyMultiplier\PayoutAPI\data.json
			String url = "https://api.sandbox.paypal.com/v1/payments/payouts";
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("accept", "application/json");
			httpsURLConnection.setRequestProperty("authorization", "Bearer A21AAF2JdzIhPLzOEAe19J9C-gwiUclS457Zi5-3TWZrw91LYYpPtFUFAyb16stnXnbogU39xlGYZQg3hNp7B-ml0Aj0hcE5Q");
			httpsURLConnection.setRequestProperty("content-type", "application/json");
	
			// Send request
			httpsURLConnection.setDoOutput(true);
			DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
			dataOutputStream.writeBytes(jsonArray.toString());
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

			// Print the response
			System.out.println(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}



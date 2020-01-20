package net.geekstest.parserdata.Shaparak;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class ShaparakPaymentCreate {
	public static void main(String[] args) {
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("E:\\Xine\\ProjectCode\\Android\\MoneyMultiplier\\IdPayPAPI\\data-farsi.json"));
			System.out.println(jsonObject.toString());
			
			//curl -X POST https://api.idpay.ir/v1.1/payment 
			//-H "Content-Type: application/json" 
			//-H "X-API-KEY: 0174ae8a-b71d-4e0d-9121-414f775d3592" 
			//-H "X-SANDBOX: 1" 
			//-d @E:\Xine\ProjectCode\Android\MoneyMultiplier\IdPayPAPI\data-farsi.json
			String url = "https://api.idpay.ir/v1.1/payment";
			URL urlObject = new URL(url);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlObject.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("Content-Type","application/json");
			httpsURLConnection.setRequestProperty("X-API-KEY", "0174ae8a-b71d-4e0d-9121-414f775d3592");
			httpsURLConnection.setRequestProperty("X-SANDBOX", "1");
	
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

			// Print the response
			System.out.println(response);
			
			JSONObject responseJsonObject = (JSONObject) new JSONParser().parse(response.toString());
			System.out.println("Link == " + responseJsonObject.get("link"));
			
			openWebpage(URI.create(responseJsonObject.get("link").toString()));
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



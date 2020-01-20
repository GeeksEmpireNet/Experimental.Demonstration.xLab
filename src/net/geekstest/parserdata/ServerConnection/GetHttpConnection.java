package net.geekstest.parserdata.ServerConnection;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;

public class GetHttpConnection {
	public static void main(String[] args) {		
		// The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet httpGet = new HttpGet("http://api.currencylayer.com/live?access_key=3057d94042a99324b134799aa7c252f9");
        
        try {
            CloseableHttpResponse response =  HttpClients.createDefault().execute(httpGet);
            HttpEntity entity = response.getEntity();

            String fullJsonResponse = EntityUtils.toString(entity);
            System.out.println(fullJsonResponse);
            
            JSONParser jsonParser = new JSONParser();
            JSONObject fullJson = (JSONObject) jsonParser.parse(fullJsonResponse);
            System.out.println(fullJson.get("quotes"));
            
            HashMap<String, Long> rates = (HashMap<String, Long>) fullJson.get("quotes");
            rates.keySet().forEach( key -> {
            	System.out.println(key + ": " + rates.get(key));
            });

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (net.geekstest.parserdata.JSON.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



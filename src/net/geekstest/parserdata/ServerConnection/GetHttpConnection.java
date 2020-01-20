package net.geekstest.parserdata.ServerConnection;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetHttpConnection {
	public static void main(String[] args) {		
		// The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet("http://api.currencylayer.com/live?access_key=3057d94042a99324b134799aa7c252f9");

        try {
            CloseableHttpResponse response =  HttpClients.createDefault().execute(get);
            HttpEntity entity = response.getEntity();

            System.out.println(EntityUtils.toString(entity));
            //EntityUtils.toString(entity);

            System.out.println("Live Currency Exchange Rates");

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}



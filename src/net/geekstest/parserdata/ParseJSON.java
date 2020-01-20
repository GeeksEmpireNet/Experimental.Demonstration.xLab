package net.geekstest.parserdata;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import net.geekstest.parserdata.JSON.JSONArray;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;
import net.geekstest.parserdata.JSON.ParseException;

public class ParseJSON {

	public static void main(String args[]) {

		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("C:\\Users\\Xtation\\Desktop\\RevolutDataSample.json");
									
			JSONObject fullJson = (JSONObject) jsonParser.parse(reader);
			System.out.println(fullJson.size());

			System.out.println(fullJson.get("base"));
			System.out.println(fullJson.get("date"));
			
			
			System.out.println(fullJson.get("rates"));
			JSONObject jsonObject = (JSONObject) fullJson.get("rates"); 
			System.out.println(jsonObject.get("USD"));
			
			jsonObject.keySet().forEach(keyStr -> {
		        Object keyvalue = jsonObject.get(keyStr);
		        System.out.println("key: "+ keyStr + " value: " + keyvalue);

		        //for nested objects iteration if required
		        //if (keyvalue instanceof JSONObject)
		        //    printJsonObject((JSONObject)keyvalue);
		    });
			

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("C:\\Users\\Xtation\\Desktop\\SuperShortcutsPro.json")) {
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			JSONArray rawEmailsList = (JSONArray) obj.get("users");
			
			LinkedHashSet<JSONObject> hashSet = new LinkedHashSet<JSONObject>(rawEmailsList);
			List<JSONObject> emailsList = new ArrayList<JSONObject>(hashSet);
			for (JSONObject user : emailsList) {
				System.out.println("\'" + user.get("email") + "\'" + ",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	}
}

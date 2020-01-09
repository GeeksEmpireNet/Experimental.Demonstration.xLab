package net.geekstest.parserdata;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import net.geekstest.parserdata.JSON.JSONArray;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;
import net.geekstest.parserdata.JSON.ParseException;

public class ParseJSON {

	public static void main(String args[]) {

		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("C:\\Users\\Xtation\\Desktop\\heritage.json");
			
			long firstTime = System.currentTimeMillis();
			System.out.println(">>> " + firstTime);
			
			JSONArray fullJsonArray = (JSONArray) jsonParser.parse(reader);
			
			long secondTime = System.currentTimeMillis();
			System.out.println(">>> " + secondTime);
			
			System.out.println(">>> " + ((secondTime - firstTime)));
			
			
			//JSONObject primeNumbers = (JSONObject) obj.get("name");

			JSONObject arrayList = (JSONObject) fullJsonArray.get(0);
			System.out.println("Heritage ::: " + arrayList.get("name"));

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

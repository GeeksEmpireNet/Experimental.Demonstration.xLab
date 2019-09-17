package net.geekstest.parserdata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import net.geekstest.parserdata.JSON.JSONArray;
import net.geekstest.parserdata.JSON.JSONObject;
import net.geekstest.parserdata.JSON.JSONParser;
import net.geekstest.parserdata.JSON.ParseException;

public class ParseJSON {

	public static void main(String args[]) {

		JSONParser jsonParser = new JSONParser();
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
		}
	}
}

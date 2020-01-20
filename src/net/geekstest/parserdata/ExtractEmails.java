package net.geekstest.parserdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ExtractEmails {

	public static void main(String args[]) {

		List<String> rawEmailsList = new ArrayList<String>();
		
		String[] emailsAddress = readFileLine("C:\\Users\\Xtation\\Desktop\\PPOM_USERS.JSON");
		for(String email : emailsAddress) {			
			if (email.contains("@")) {
				//System.out.println("\'" + email + "\'" + ",");
				
				rawEmailsList.add("\'" + email + "\'" + ",");
			}
		}
		LinkedHashSet<String> hashSet = new LinkedHashSet<String>(rawEmailsList);
		List<String> emailsList = new ArrayList<String>(hashSet);
		for (String email : emailsList) {
			System.out.println(email);
		}
	}
	
	public static String[] readFileLine(String fileName) {
        String[] contentLine = null;
        try {
            FileInputStream fin = new FileInputStream(new File(fileName));
            BufferedReader myDIS = new BufferedReader(new InputStreamReader(fin));

            int count = countLine(fileName);
            contentLine = new String[count];
            String line = "";
            int i = 0;
            while ((line = myDIS.readLine()) != null) {
                contentLine[i] = line;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentLine;
    }
	
	 public static int countLine(String fileName) {
		 int nLines = 0;
	     try {
	    	 BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
	    	 while (reader.readLine() != null) {
	    		 nLines++;
	    	 }
	    	 reader.close();
	     } catch (Exception e) {
	    	 e.printStackTrace();
	    	 nLines = 0;
	     }
	     return nLines;
	 }
	 
	 public static void saveFileAppendLine(String content) {
		 try {
			 FileOutputStream fOut = new FileOutputStream(new File("C:\\Users\\Xtation\\Desktop\\emails.txt"), true);
			 fOut.write((content + "\n").getBytes());

			 fOut.flush();
			 fOut.close();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}

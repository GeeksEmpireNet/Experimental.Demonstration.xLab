package net.geekstest.parserdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ParserData {

	public static void main(String args[]) {
			
		File[] files = new File("C:\\Users\\Xtation\\Desktop\\xml").listFiles();
		for(File aFile : files) {
			/*String fileName = aFile.getName();
			System.out.println(aFile.getName());
			
			File renameFile = new File("C:\\Users\\Xtation\\Desktop\\xml\\" + fileName.replace("betaTesters%2FAPI25%2F", ""));
			aFile.renameTo(renameFile);
			System.out.println(renameFile.getName());*/
			
			try {
				System.out.println(aFile.getName());
				
				 // pass the path to the file as a parameter
			    FileReader fileReader = new FileReader(aFile);
			    BufferedReader bufferedReader = new BufferedReader(new FileReader(aFile));
			    
			    String aLine = "";
			    while ((aLine = bufferedReader.readLine()) != null) {
			    	/*if (aLine.contains("testerEmail")) {
			    	//	System.out.println(aLine);
			    		String testerEmail = aLine.substring(aLine.indexOf(">") + 1, aLine.indexOf("</"));
			    		System.out.println(testerEmail + "\n");
					}*/
			    	
			    	if (aLine.contains("@")) {
			    	//	System.out.println(aLine);
			    		String testerEmail = aLine;
			    		System.out.println(testerEmail + "\n");
					}
			    }
			} catch (Exception e) {e.printStackTrace();}
		}
	
		
		/*File xmlFile = new File("C:\\Users\\Xtation\\Desktop\\xml\\" + "test" + ".xml");
		try {
			 // pass the path to the file as a parameter
		    FileReader fileReader = new FileReader(xmlFile);
		    BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlFile));
		    
		    String aLine = "";
		    while ((aLine = bufferedReader.readLine()) != null) {
		    	if (aLine.contains("testerEmail")) {
		    		System.out.println(aLine);
		    		String testerEmail = aLine.substring(aLine.indexOf(">") + 1, aLine.indexOf("</"));
		    		System.out.println(testerEmail);
				}
		    }
		} catch (Exception e) {e.printStackTrace();}*/

	}
}

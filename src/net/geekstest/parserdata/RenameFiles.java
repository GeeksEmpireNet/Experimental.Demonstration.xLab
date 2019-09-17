package net.geekstest.parserdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class RenameFiles {

	public static void main(String args[]) {
		String[] episodesNames = readFileLine("C:\\Users\\Xtation\\Desktop\\SeasonEpisodes");
		File[] episodesFiles = new File("C:\\Users\\Xtation\\Desktop\\TheBigBangTheorySeason2").listFiles();
 		
		for(String episodeName : episodesNames) {
			System.out.println(" >>> " + episodeName);
		}
		
		int i = 0;
		for(File episodeFile : episodesFiles) {
			System.out.println(">>> " + episodeFile.getName());
			episodeFile.renameTo(new File("C:\\Users\\Xtation\\Desktop\\TheBigBangTheorySeason2\\" + (i + 1) + "." + episodesNames[i] + ".mkv"));
			i++;
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
}

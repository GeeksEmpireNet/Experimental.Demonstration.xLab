package net.geekstest.parserdata;

import java.io.File;
import java.io.FileOutputStream;

public class ExtractPrimeNumbers {

	public static void main(String args[]) {
		
		//String[] adds = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen"};
		
		saveJsonAppendLine("{");
		saveJsonAppendLine("\"PrimeNumbers\" : {");
		//int primeFileCounter = 0, fileNameAdditional = 0;
		for (int i = 2; i < 10000; i++) {
			if (checkPrime(i)) {
				//primeFileCounter++;
				
				//System.out.println(i);
				/*if (primeFileCounter == 100) {
					primeFileCounter = 0;
					fileNameAdditional++;
				}*/
				
				
				//saveFileAppendLine("primes_value_" + adds[fileNameAdditional] + ".txt", "<string name=\"a" + i +"\" translatable=\"false\">" + i + "</string>");
				saveJsonAppendLine("\"" + i + "\"" + ":" + i + ",");
			}
		}
		saveJsonAppendLine("}");
		saveJsonAppendLine("}");
	}
	
	static boolean checkPrime(int n) {
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				
				return false;
			}
		}

		return true;
	}
	
	public static void saveJsonAppendLine(String content) {
		 try {
			 System.out.println(content);
			 
			 FileOutputStream fOut = new FileOutputStream(new File("C:\\Users\\Xtation\\Desktop\\PrimeNumbers.json"), true);
			 fOut.write((content + "\n").getBytes());

			 fOut.flush();
			 fOut.close();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	
	 public static void saveFileAppendLine(String fileName, String content) {
		 try {
			 FileOutputStream fOut = new FileOutputStream(new File("C:\\Users\\Xtation\\Desktop\\Primes\\" + fileName), true);
			 fOut.write((content + "\n").getBytes());

			 fOut.flush();
			 fOut.close();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}

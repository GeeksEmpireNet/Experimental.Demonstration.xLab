package net.geekstest.parserdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetRandomNumber {

	public static void main(String args[]) {
		
		int[] allNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9/*, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19*/};
		List<Integer> listAllNumbers = new ArrayList<>();
				
		
		Random random = new Random();
		String nowTime = "" + System.currentTimeMillis();
		int randomElement = allNumbers[random.nextInt(allNumbers.length)];
		
		System.out.println(nowTime);
		System.out.println(nowTime.charAt(nowTime.length() - 1));
		System.out.println(randomElement);
	}
}

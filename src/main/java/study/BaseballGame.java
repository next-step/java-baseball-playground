package study;

import java.util.Scanner;

public class BaseballGame {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CheckBaseballNumbers cbn = new CheckBaseballNumbers();
		String randomNumber = cbn.converseIntToString(cbn.generateRandomNumber());
		
		int maxStrike = 0;
		
		String numbers = sc.next();
		System.out.print("숫자를 입력해 주세요 : ");
		
		/*
		 * while (maxStrike != 3) {
		 * 
		 * 
		 * Baseball result = cbn.checkBallAndStrike(numbers, randomNumber);
		 * System.out.println(cbn.tellBallAndStrike(result));
		 * 
		 * maxStrike = result.getStrike(); }
		 */
	}
}

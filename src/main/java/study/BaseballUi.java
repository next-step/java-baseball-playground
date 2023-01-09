package study;

import java.util.Scanner;

public class BaseballUi {
	
	Scanner sc = new Scanner(System.in);
	CheckBaseballNumbers cbn = new CheckBaseballNumbers();

	public void run() {
		System.out.print("숫자를 입력해 주세요 : ");
		String numbers = sc.next();
		System.out.println(numbers);

		String randomNumber = cbn.converseIntToString(cbn.generateRandomNumber());
		System.out.println(randomNumber);
		
		
		
	}
	
	
	
	int maxStrike = 0;
	
	/* String numbers = sc.next(); */
	
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

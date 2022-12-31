package study;

import java.util.Scanner;

public class BaseballGame {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int randomNumber = generateRandomNumber();
		
		System.out.print("숫자를 입력해 주세요");
		String numbers = sc.next();
	}
	
	public static int generateRandomNumber() {
		int randomNumber = (int) (Math.random()*889 + 111);
		return randomNumber;
	}

}

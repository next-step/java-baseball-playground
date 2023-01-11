package study.baseball;

import java.util.Scanner;

public class BaseballUi {
	
	Scanner sc = new Scanner(System.in);
	CheckBaseballNumbers cbn = new CheckBaseballNumbers();
	String numbers = " ";
	Baseball result;

	public void run() {

		String randomNumber = cbn.converseIntToString(cbn.generateRandomNumber());
		
		int maxStrike = 0;
		
		while (maxStrike != 3) {
			
			System.out.print("숫자를 입력해 주세요 : ");
			numbers = sc.next();
			checkNumbersRange(numbers);
			result = cbn.checkBallAndStrike(numbers, randomNumber);
			
			System.out.println(cbn.tellBallAndStrike(result));
			
			maxStrike = result.getStrike(); 
			checkResultNumbers(maxStrike);
		}	
	}
	
	public void checkResultNumbers(int maxStrike) {
		int restartOrExit = 0;

		if (maxStrike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restartOrExit = sc.nextInt();
		}
		
		if (restartOrExit == 1) {
			run();
			return;
		}  
		
		if (restartOrExit == 2) { 
			System.exit(0); 
		}
		 
	}
	
	public void checkNumbersRange(String numbers) {
		
		if (numbers.length() !=3 || Integer.parseInt(numbers) > 999 || Integer.parseInt(numbers) < 111) {
			System.out.println("숫자의 범위가 잘못됐습니다. 다시입력해주세요.");
			this.numbers = sc.next();
			checkNumbersRange(this.numbers);
			return;
		}
		return;
	}
}	

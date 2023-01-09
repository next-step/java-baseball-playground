package study;

import java.util.Scanner;

public class BaseballUi {
	
	Scanner sc = new Scanner(System.in);
	CheckBaseballNumbers cbn = new CheckBaseballNumbers();

	public void run() {

		String randomNumber = cbn.converseIntToString(cbn.generateRandomNumber());
		
		int maxStrike = 0;
		
		while (maxStrike != 3) {
			System.out.println(randomNumber);
			System.out.print("숫자를 입력해 주세요 : ");
			String numbers = sc.next();
			Baseball result = cbn.checkBallAndStrike(numbers, randomNumber);
			System.out.println(cbn.tellBallAndStrike(result));
			
			maxStrike = result.getStrike(); 
			System.out.println(maxStrike);
			checkResultNumbers(maxStrike);
		}	
	}
	
	public void checkResultNumbers(int maxStrike) {
		int restartOrExit = 0;
		System.out.println("test");
		if (maxStrike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restartOrExit = sc.nextInt();
		}
		
		if (restartOrExit == 1) {
			run();
			return;
		}  
		
		if (restartOrExit == 2){
			System.exit(0);
		}
	}
}

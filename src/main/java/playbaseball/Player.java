package playbaseball;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {
	private boolean gameBreak = false;
	Scanner sc = new Scanner(System.in);

	public void setGameBreak(boolean gameBreak) {
		this.gameBreak = gameBreak;
	}
	
	public void playBall() {
		while (!gameBreak) {
			inputBall();
		}
	}
	
	public void inputBall() {
		System.out.print("숫자를 입력해 주세요 : ");
		String nums = sc.next();
		if ( validateInput(nums) ) {
			System.out.println(nums);
		}
	}
	
	public boolean validateInput(String nums) {
		if (!checkLength(nums)) return false;
		if (!checkNumType(nums)) return false;
		if (!checkDuplicate(nums)) return false;
		return true;
	}
	
	public boolean checkLength(String nums) {
		if ( nums.length() < 3 ) {
			System.out.println("세자리를 입력해주세요");
			return false;
		}
		return true;
	}
	
	public boolean checkNumType(String nums) {
		try {
			Integer.parseInt(nums);
		}
		catch (Exception e) {
			System.out.println("숫자를 입력해주세요");
			return false;
		}
		return true;
	}
	
	public boolean checkDuplicate(String nums) {
		Set<Character> numSet = new HashSet<>();
		for ( char numsArr : nums.toCharArray() ) {
			numSet.add(numsArr);
		}
		return numSet.size() == 3;
	}
}

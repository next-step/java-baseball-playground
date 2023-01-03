package study;

public class CheckBaseballNumbers {

	private String randomNumbers;
	
	public CheckBaseballNumbers() {
		
	}
	
	public int generateRandomNumber() {
		int randomNumber = (int) (Math.random()*889 + 111);
		return randomNumber;
	}
	
	public String converseIntToString(int randomNumbers) {
		StringBuffer sb = new StringBuffer();
		
		while (randomNumbers != 0) {
			int temp = 0;
			temp = randomNumbers%10;
			sb.insert(0, temp);
		}
		
		return sb.toString();
	}
	
	public String tellBallAndStrike (Baseball baseball) {
		StringBuffer sb = new StringBuffer();
		
		if (baseball.getBall() != 0) {
			sb.append(baseball.getBall() + "볼 ");
		}
		
		if (baseball.getStrike() != 0) {
			sb.append(baseball.getStrike() + "스트라이크");
		}
		
		return sb.toString();
	}
	
	public Baseball checkBallAndStrike (String numbers, String randomNumbers) {
		int strike = 0;
		int ball = 0;
		
		for (int i=0; i<3; i++) {
			strike += checkStrike(numbers, randomNumbers, i);
			ball += checkBall(numbers, randomNumbers, i);
		}
		
		Baseball result = new Baseball(strike, ball);
		return result;
	}
	
	public int checkStrike(String numbers, String randomNumbers, int idx) {
		int count = 0;
		
		if (randomNumbers.charAt(idx) == numbers.charAt(idx)) {
			count++;
		}
	
		return count;
	}
	
	public int checkBall(String numbers, String randomNumbers, int idx) {
		int count = 0;
		
		if (randomNumbers.contains(String.valueOf(numbers.charAt(idx))) 
				  && randomNumbers.charAt(idx) != numbers.charAt(idx)) {
			count++;
		}
		
		return count;
	}
}

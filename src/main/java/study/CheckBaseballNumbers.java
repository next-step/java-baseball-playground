package study;

public class CheckBaseballNumbers {

	private String randomNumbers;
	
	public CheckBaseballNumbers() {
		
	}
	
	public String conversionIntToString(int randomNumbers) {
		StringBuffer sb = new StringBuffer();
		
		while (randomNumbers != 0) {
			int temp = 0;
			temp = randomNumbers%10;
			sb.insert(0, temp);
		}
		
		return sb.toString();
	}
	
	public String checkStrike(String numbers, int randomNumbers) {
		String stringRandomNumbers = conversionIntToString(randomNumbers);
		String result = " ";
		int count = 0;
		
		if (stringRandomNumbers.charAt(0) == numbers.charAt(0)) {
			count++;
		}
		
		return result;
	}
}

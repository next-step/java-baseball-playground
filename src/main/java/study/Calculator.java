package study;

import java.util.Scanner;

public class Calculator {

	int answer;
	Scanner scanner = new Scanner(System.in);

	/*
	 * 필요한 기능
	 * 1. 제대로 split를 진행하는지
	 * 2. split 된 문자열을 제대로 parseInt로 변환하는지
	 * 3. 계산을 정상적으로 수행하는지
	 */

	public void Start() {
		String formula = scanner.nextLine();

		String[] numberAndOperator = split(formula);
	}

	public String[] split(String nums) {
		return nums.split(" ");
	}

	public void operate(int nums, String operator) {

	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}
}

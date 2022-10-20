package study;

import java.util.Scanner;

public class StringCalculator {

  static int[] numberArray;
  static String[] operatorArray;
  public int inputString() {
    Scanner scanner = new Scanner(System.in);
    String value = scanner.nextLine();
    String[] values = value.split(" ");
    parseInputString(values);
    return calculate();

  }

  public void parseInputString(String[] values) {
    numberArray = new int[values.length/2 + 1];
    operatorArray = new String[values.length/2];

    numberArray[0] = Integer.parseInt(values[0]);

    for (int i = 2; i <= values.length; i += 2) {
      numberArray[i/2] = Integer.parseInt(values[i]);
    }

    for (int i = 1; i <= values.length-2; i += 2) {
      operatorArray[i/2] = values[i];
    }


  }

  public int operatorCal(int firstNumber, int secondNumber, String operator) {
    if (operator.equals("+")) return add(firstNumber, secondNumber);
    if (operator.equals("-")) return minus(firstNumber, secondNumber);
    if (operator.equals("*")) return multiply(firstNumber, secondNumber);
    if (operator.equals("/")) return divide(firstNumber, secondNumber);

    return 0;
  }

  public int calculate() {
    int[] number = StringCalculator.numberArray;
    String[] operator = StringCalculator.operatorArray;
    int result;
    result = operatorCal(number[0], number[1], operator[0]);

    for (int i = 1; i < number.length - 1; i++) {
      result = operatorCal(result, number[i + 1], operator[i]);
    }
    return result;
  }

  public int add(int firstNumber, int secondNumber) {
    return firstNumber + secondNumber;
  }

  public int minus(int firstNumber, int secondNumber) {
    return firstNumber - secondNumber;
  }

  public int multiply(int firstNumber, int secondNumber) {
    return firstNumber * secondNumber;
  }

  public int divide(int firstNumber, int secondNumber) {
    return firstNumber / secondNumber;
  }

}

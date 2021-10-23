package BaseballGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    Queue<Integer> intQ = new LinkedList<>();
    Queue<Character> charQ = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public int add(int i, int j) {
        return i+j;
    }

    public int subtract(int i, int j) {
        return i-j;
    }

    public int multiply(int i, int j) {
        return  i*j;
    }

    public int divide(int i, int j) {
        return i/j;
    }

    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int calculateString(String value) {
        String[] values = value.split(" ");

        for (int i = 0; i < values.length; i++) {
            if (isStringInt(values[i])) {
                intQ.offer(Integer.parseInt(values[i]));
            }

            if (values[i] == " ") {
                continue;
            }

            if (!isStringInt(values[i])) {
                charQ.offer(values[i].charAt(0));
            }
        }

        int leftInt = intQ.poll();
        int rightInt = intQ.poll();
        char command = charQ.poll();

        while (true) {
            if (command == '+') {
                leftInt = add(leftInt, rightInt);
            }
            if (command == '-') {
                leftInt = subtract(leftInt, rightInt);
            }
            if (command == '*') {
                leftInt = multiply(leftInt, rightInt);
            }
            if (command == '/') {
                leftInt = divide(leftInt, rightInt);
            }
            if (!intQ.isEmpty()) {
                rightInt = intQ.poll();
                command = charQ.poll();
            } else {
                break;
            }
            continue;
        }
        return leftInt;
    }
}

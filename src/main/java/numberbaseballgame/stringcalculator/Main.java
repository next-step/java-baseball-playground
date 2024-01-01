package numberbaseballgame.stringcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int sum = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (i % 2 != 0) {
                switch (values[i]) {
                    case "+" -> sum += Integer.parseInt(values[i + 1]);
                    case "-" -> sum -= Integer.parseInt(values[i + 1]);
                    case "*" -> sum *= Integer.parseInt(values[i + 1]);
                    case "/" -> {
                        try {
                            sum /= Integer.parseInt(values[i + 1]);
                        } catch (ArithmeticException e) {
                            System.out.println("0으로 나눌 수 없습니다.");
                            System.exit(1);
                        }
                    }
                    default -> {
                        System.out.println("잘못된 연산자입니다.");
                        System.exit(1);
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

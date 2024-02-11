package numberbaseballgame.stringcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("계산식을 입력하세요.(예) 3 + 4 * 2 / 2)");
            String value = scanner.nextLine();
            String[] values = value.split(" ");

            try {
                int sum = Integer.parseInt(values[0]);
                for (int i = 1; i < values.length; i++) {
                    if (i % 2 != 0) {
                        switch (values[i]) {
                            case "+" -> sum += Integer.parseInt(values[i + 1]);
                            case "-" -> sum -= Integer.parseInt(values[i + 1]);
                            case "*" -> sum *= Integer.parseInt(values[i + 1]);
                            case "/" -> sum /= Integer.parseInt(values[i + 1]);
                            default -> System.out.println("잘못된 연산자입니다.");
                        }
                    }
                }
                System.out.println("계산결과 : " + sum);
                break;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

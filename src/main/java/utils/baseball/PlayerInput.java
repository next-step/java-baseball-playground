package utils.baseball;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInputNumber() {
        System.out.print("숫자를 입력해 주세요:");
        String inputNumber = scanner.nextLine();
        validateInputNumber(inputNumber);
        return inputNumber;
    }

    public static void validateInputNumber(String inputNumber) {
        Pattern pattern = Pattern.compile("^[1-9][1-9][1-9]$");
        Matcher matcher = pattern.matcher(inputNumber);
        if(!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

    public static String getInputGameOption() {
        System.out.print("\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputOption = scanner.nextLine();
        validateInputGameOption(inputOption);
        return inputOption;
    }


    public static void validateInputGameOption(String inputOption) {
        Pattern pattern = Pattern.compile("^[1-2]$");
        Matcher matcher = pattern.matcher(inputOption);
        if(!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }
}

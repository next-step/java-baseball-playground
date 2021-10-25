package baseball;

import baseball.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static final String THREE_STRIKE = "0 볼 3 스트라이크";
    public static final String START = "start";

    public static void main(String[] args) {

        Referee referee = new Referee();
        List<Integer> createdRandomNumbers = new ArrayList<>();
        boolean again = true;
        String result = START;

        while (again) {

            // 만약 처음 시작
            if (result.equals(START)) {
                createdRandomNumbers = new NumberGenerator().createRandomNumbers();
                System.out.println("컴퓨터가 만들어낸 숫자 : " + createdRandomNumbers);
            }

            // 만약 result의 값이 3 스트라이크가 아니라면
            if (!isEqualsThreeStrike(result)) {
                result = referee.compare(createdRandomNumbers, askNumber());
                System.out.println(result);
            }

            // 만약 result의 값이 3스트라이크라면
            if (isEqualsThreeStrike(result)) {
                again = referee.gameAgain();
                result = START;
            }
        }
    }

    private static boolean isEqualsThreeStrike(String result) {
        return result.equals(THREE_STRIKE);
    }

    public static List<Integer> askNumber() {

        System.out.print("숫자를 입력해 주세요 : ");
        String input = new Scanner(System.in).next();

        List<Integer> numbers = new ArrayList<>();

        for (String number : input.split("")) {
            int convertNumber = Integer.parseInt(number);
            numbers.add(convertNumber);
        }

        return numbers;
    }
}
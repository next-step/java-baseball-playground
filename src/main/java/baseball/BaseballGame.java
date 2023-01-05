package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {

    // 1. 서로 다른 수로 이루어진 3자리의 수를 생성한다.
    public String createNumber() {
        final Random random = new Random();
        final Set<String> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(String.valueOf(random.nextInt(9) + 1));
        }

        return set.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // 2. 숫자를 입력 받는다.
    public String getInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");

        // 2-1. 문자열을 입력 받는다.
        final Scanner kb = new Scanner(System.in);
        final String inputString = kb.nextLine();

        // 2-2. 숫자인지 검증한다.
        isNumber(inputString);

        return inputString.trim();
    }

    private void isNumber(final String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("숫자를 입력해주세요");
        }
    }
}

package numberbaseballgame.stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputReader {

    private static final Pattern INT_PATTERN = Pattern.compile("^-?\\d+$");
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d{1,10}$");

    private final List<String> userInput;

    public UserInputReader() {
        userInput = new ArrayList<>();
    }

    // 입력받은 문자열을 알맞은 형태로 바꿔준다
    public List<String> convert(String input, String character) {
        return validate(splitBy(input, character));
    }

    // 입력받은 문자를 검증한다.
    private List<String> validate(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            if (isNumberic(input, i)) {
                throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다");
            }

            if (isOperator(input, i)) {
                throw new IllegalArgumentException("연산 기호가 아닌 문자를 입력하셨습니다.");
            }

            if (isInteger(input, i)) {
                throw new IllegalArgumentException("숫자는 10자리까지만 입력이 가능합니다.");
            }
        }
        return Collections.unmodifiableList(input);
    }

    // 입력받은 문자열을 공백을 기준으로 나눈다
    private List<String> splitBy(String input, String character) {
        String[] inputs = input.split(character);
        userInput.addAll(Arrays.asList(inputs));
        return userInput;
    }

    // 숫자인지 검증한다
    private boolean isNumberic(List<String> input, int i) {
        return i % 2 == 0 && !INT_PATTERN.matcher(input.get(i)).matches();
    }

    // 사칙연산 기호인지 검증한다
    private boolean isOperator(List<String> input, int i) {
        return i % 2 == 1 && !OPERATOR_PATTERN.matcher(input.get(i)).matches();
    }

    // 피연산자가 10자리여야 한다
    private boolean isInteger(List<String> input, int i) {
        return i % 2 == 0 && !INTEGER_PATTERN.matcher(input.get(i)).matches();
    }

    // 0으로 나눴을 때 ArithmeticException
    // 연산자가 먼저 오면 안된다 ex) + 1 + 2
    // 연산자를 연속해서 입력하면 안된다 ex) 1 ++ 2
    // 첫번째는 무조건 숫자가 와야된다 NumberFormatException

    public List<String> getUserInput() {
        return userInput;
    }

}

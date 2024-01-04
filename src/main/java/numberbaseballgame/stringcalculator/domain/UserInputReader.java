package numberbaseballgame.stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputReader {

    private static final Pattern intPattern = Pattern.compile("^-?\\d+$");
    private static final Pattern operatorPattern = Pattern.compile("[+\\-*/]");

    // 이렇게 변수를 두개를 나누니 복잡도가 올라감. Calculate에서 한번에 처리하고 싶은데 나눠서 처리할 수 밖에 없게 됨
//    ArrayList<Integer> numbers = new ArrayList<>();
//    ArrayList<Character> operators = new ArrayList<>();
    private final List<String> userInput;

    public UserInputReader() {
        userInput = new ArrayList<>();
    }

    // 입력받은 문자열을 공백을 기준으로 나눈다
    public List<String> splitBy(String input, String character) {
        String[] inputs = input.split(character);
        userInput.addAll(Arrays.asList(inputs));
        return userInput;
    }

    // 숫자인지 검증한다
    public boolean isNumberic(String input) {
        return intPattern.matcher(input).matches();
    }

    // 사칙연산 기호인지 검증한다
    public boolean isOperator(String input) {
        return operatorPattern.matcher(input).matches();
    }

    // 0으로 나눴을 때 ArithmeticException
    // 연산자가 먼저 오면 안된다 ex) + 1 + 2
    // 연산자를 연속해서 입력하면 안된다 ex) 1 ++ 2
    // 피연산자가 10자리여야 한다
    // 첫번째는 무조건 숫자가 와야된다 NumberFormatException

    public List<String> getUserInput() {
        return userInput;
    }

}

package calculator.domain;

import java.util.*;
import java.util.regex.Pattern;

public class UserInputReceiver {

    private List<String> userInput;

    private static final Pattern digitPattern = Pattern.compile("^\\d{1,10}");
    private static final Pattern operatorPattern = Pattern.compile("^[+\\-/%]{1}");

    public void receive(String inputString, String delimiter) {
        this.userInput = validate(splitBy(inputString, delimiter));
    }

    private List<String> validate(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            if(isDigit(input, i)){
                throw new IllegalArgumentException("숫자는 10자리가 넘어서는 안됩니다.");
            }
            if(isOperator(input, i)) {
                throw new IllegalArgumentException("연산자는 +,-,/,% 중에 하나여야 합니다.");
            }
        }

        return Collections.unmodifiableList(input);
    }

    private static boolean isOperator(List<String> input, int i) {
        return i % 2 == 1 && !operatorPattern.matcher(input.get(i)).matches();
    }

    private static boolean isDigit(List<String> input, int i) {
        return i % 2 == 0 && !digitPattern.matcher(input.get(i)).matches();
    }

    private List<String> splitBy(String input, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(input,delimiter);
        List<String> userInput = new ArrayList<>();

        while(tokenizer.hasMoreElements()){
            userInput.add(tokenizer.nextToken());
        }

        return userInput;
    }

    public List<String> getUserInput() {
        return userInput;
    }
}

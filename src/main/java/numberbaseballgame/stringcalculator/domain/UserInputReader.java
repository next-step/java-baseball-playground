package numberbaseballgame.stringcalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputReader {

    private static final Pattern intPattern = Pattern.compile("^-?\\d+$");

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

    // 숫자인지 확인한다
    public boolean isNumberic(String input) {
        return intPattern.matcher(input).matches();
    }

    public List<String> getUserInput() {
        return userInput;
    }

}

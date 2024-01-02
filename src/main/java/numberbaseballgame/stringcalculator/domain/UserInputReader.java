package numberbaseballgame.stringcalculator.domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputReader {

    private static final Pattern intPattern = Pattern.compile("^-?\\d+$");

    // 이렇게 변수를 두개를 나누니 복잡도가 올라감. Calculate에서 한번에 처리하고 싶은데 나눠서 처리할 수 밖에 없게 됨
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Character> operators = new ArrayList<>();

    // 입력값을 읽어들인다
    public void read() {
        separateNumberAndOperator(splitInput(getInput()));
    }

    // 문자열을 입력받는다
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // 입력받은 문자열을 공백을 기준으로 나눈다
    public String[] splitInput(String input) {
        return input.split(" ");
    }

    // 나눈 문자열을 숫자와 연산자로 구분한다
    public void separateNumberAndOperator(String[] components) {
        for (String component : components) {
            if (isNumberic(component)) {
                numbers.add(Integer.parseInt(component));
            }

            if (!isNumberic(component)) {
                operators.add(component.charAt(0));
            }
        }
    }

    // 숫자인지 확인한다
    public boolean isNumberic(String input) {
        return intPattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        UserInputReader u = new UserInputReader();
        System.out.println(u.isNumberic("d"));
    }
}

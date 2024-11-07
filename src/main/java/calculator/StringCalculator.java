package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 요구사항
 * 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
 * 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
 * 3. 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.
 * 4. 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.
 * 5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.
 * 6. 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.
 */
public class StringCalculator {

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toPositives(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private int[] toPositives(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            checkIfNumberIsNegative(number);
            sum += number;
        }
        return sum;
    }

    private static void checkIfNumberIsNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}

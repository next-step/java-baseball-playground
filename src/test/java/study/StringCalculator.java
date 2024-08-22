package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {
        @Test
        @DisplayName("입력한 문자열 값에 따라 사칙연산 수행하는 계산기 구현")
        void stringCalculator() {

            String input = "2 + 3 * 10 + 5 / 5";
            InputStream inputStr = new ByteArrayInputStream(input.getBytes());
            Scanner sc = new Scanner(inputStr);
            String value = sc.nextLine();

            String[] values = value.split(" ");
            int answer = Integer.parseInt(values[0]);
            String operator = "";

            Predicate<String> predicate = (arg) -> {
                try {
                    Integer.parseInt(arg);
                    return true;
                } catch (NumberFormatException exception) {
                    return false;
                }
            };

            for(int i = 1 ; i <values.length ; i++) {
                if(predicate.test(values[i])) {
                    answer = calculator(answer,operator,Integer.parseInt(values[i]));
                } else {
                    operator = values[i];
                }
            }

            assertThat(answer).isEqualTo(11);
        }

    private int calculator(int answer, String operator ,int num) {
            switch (operator) {
                case "+" : answer += num;break;
                case "-" : answer -= num;break;
                case "/" : answer /= num;break;
                case "*" : answer *= num;break;
            }
            return answer;
    }
}

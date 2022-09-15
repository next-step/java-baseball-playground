package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator {

    @DisplayName("enum")
    public enum Operator {
        PLUS("+", (num1, num2) -> num1 + num2),
        SUBTRACT("-", (num1, num2) -> num1 - num2),
        MULTIPLY("*", (num1, num2) -> num1 * num2),
        DIVIDE("/", (num1, num2) -> num1 / num2);

        private String symbol;
        //int인자 둘을 받아 결과값 int를 리턴하는 함수
        private BiFunction<Integer, Integer, Integer> expression;

        Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public int calculate(int num1, int num2) {
            return expression.apply(num1, num2);
        }
    }

    @DisplayName("숫자 파싱")
    public ArrayList<Integer> parseInt(String value){
        //사용자 입력값중 int값들을 ArrayList로 리턴

        Pattern regex = Pattern.compile("\\d+");
        Matcher regexMatcher = regex.matcher(value);
        ArrayList<Integer> intValues = new ArrayList<>();

        while (regexMatcher.find()) {
            String val = regexMatcher.group();
            intValues.add(Integer.parseInt(val));
        }

        return intValues;
    }

    @DisplayName("계산식 파싱")
    public ArrayList<String> parseForms(String value){
        //사용자 입력값중 계산식을 String ArrayList로 리턴

        String[] values = value.split(" ");                                 //공백을 기준으로 String을 나눔
        ArrayList<String> formArray = new ArrayList<>();
        for (int i = 1; i < values.length; i+=2) {
            //계산식은 항상 홀수자리이므로 i+2로 홀수인덱스의 값을 추출
            formArray.add(values[i]);
        }

        return formArray;
    }


    @DisplayName("계산식")
    public void operator(ArrayList<Integer> ints, ArrayList<String> forms){
        //enum 열거법 초기화
        Operator plus = Operator.PLUS;
        Operator subtract = Operator.SUBTRACT;
        Operator multiply = Operator.MULTIPLY;
        Operator divide = Operator.DIVIDE;

        //첫 int값 입력
        int result = ints.get(0);

        //입력한 계산식 순서대로 결과값 도출
        for (int i = 0; i < ints.size()-1; i++) {

            if (forms.get(i).equals(plus.symbol))
                result = plus.calculate(result, ints.get(i+1));

            if (forms.get(i).equals(subtract.symbol))
                result = subtract.calculate(result, ints.get(i+1));

            if (forms.get(i).equals(multiply.symbol))
                result = multiply.calculate(result, ints.get(i+1));

            if (forms.get(i).equals(divide.symbol))
                result = divide.calculate(result, ints.get(i+1));

        }

        System.out.println("result: " + result);
    }


}

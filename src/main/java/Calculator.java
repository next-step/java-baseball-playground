import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        Calculator cc = new Calculator();
        Calculator.create(expression);
        System.out.println(cc.calculate(expression));
    }
        public static Calculator create (String expression){

            if (!validatingExpression(expression))
                throw new IllegalArgumentException("올바른 연산식이 아닙니다.");

            return new Calculator();
        }

        private static boolean validatingExpression (String expression){

            Pattern pattern = Pattern.compile("^[+\\-]?\\d( ?[*\\-+/] ?\\d)*$");
            Matcher matcher = pattern.matcher(expression);
            return matcher.find();
        }


        public int calculate (String expression) {

            String[] parsingExpression = expression.split(" ");

            int calculationResult = Integer.parseInt(parsingExpression[0]);

            String operator = "";

            int operand = 0;

            for (int i = 0; i < parsingExpression.length; i++) {

                if (i % 2 != 0) { // 홀수 인덱스에서 연산자 값 추출
                    operator = parsingExpression[i];
                    continue;
                }

                operand = Integer.parseInt(parsingExpression[i]);
                switch (operator) {
                    case "+" : calculationResult += operand; break;
                    case "-" : calculationResult -= operand; break;
                    case "*" : calculationResult *= operand; break;
                    case "/" : {
                        if (operand != 0) calculationResult /= operand;
                        else throw new ArithmeticException("0을 나눌 수 없습니다.");
                        break;
                    }
                }

            }
            return calculationResult;
        }

}

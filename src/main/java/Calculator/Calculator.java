package Calculator;

import java.util.regex.Pattern;

public class Calculator {
    Pattern numbers = Pattern.compile("^[0-9]*$");
    public int calculate(String[] formula) {
        Operator operator = Operator.PLUS;
        int result = 0;
        for(String value : formula) {
            if(numbers.matcher(value).find()) {
                result = operator.operate(result, value);
                continue;
            }
            operator = Operator.findByOperator(value);
        }

        return result;
    }
}

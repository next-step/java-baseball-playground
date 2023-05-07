import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class StringCalc {
    static final String NUMBER_REGEXP = "^[0-9]*$";
    public int calc(String calcString) {
        String[] values = calcString.split(" ");

        int sum = Integer.valueOf(values[0]);
        String symbol = "+";
        for (int i = 1; i < values.length; i++) {


            if(Pattern.matches(NUMBER_REGEXP, values[i])){

            }
//            if (symbolMap.contains(values[i])) {
//                symbol = values[i];
//                continue;
//            }

            int targetNumber = Integer.valueOf(values[i]);
            switch (symbol) {
                case "+":
                    sum = sum + targetNumber;
                    break;
                case "-":
                    sum = sum - targetNumber;
                    break;
                case "*":
                    sum = sum * targetNumber;
                    break;
                case "/":
                    sum = sum / targetNumber;
                    break;
            }

        }
        return sum;
    }
}

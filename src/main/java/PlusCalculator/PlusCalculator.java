package PlusCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusCalculator {
    public static int calculate(String formula) {
        if(formula == null || formula.isEmpty()) {
            return 0;
        }

        if(formula.length() == 1) {
            return Integer.valueOf(formula);
        }

        if(formula.contains("-")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        if(formula.contains(",") || formula.contains(":")) {
            String[] tokens = formula.split(",|:");
            return plus(tokens);
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(formula);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return plus(tokens);
        }

        return 1;
    }

    private static int plus(String[] results) {
        int sum = 0;
        for(int i  = 0; i < results.length; i++) {
            sum += Integer.valueOf(results[i]);
        }
        return sum;
    }
}

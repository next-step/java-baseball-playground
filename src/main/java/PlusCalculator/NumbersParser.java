package PlusCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersParser {
    public static String[] parse(String formula) {
        if(formula == null || formula.isEmpty()) {
            return new String[]{"0"};
        }

        if(formula.length() == 1) {
            return new String[]{formula};
        }

        if(formula.contains("-")) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        if(formula.contains(",") || formula.contains(":")) {
            return formula.split(",|:");
        }

        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(formula);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return null;
    }
}

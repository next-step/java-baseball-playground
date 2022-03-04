package study;

import java.util.Arrays;

public class StringCalculator {

    public String[] split(String value, String separator) {
        if (value == null) {
            return new String[]{};
        }

        return value.split(separator);
    }

    public int[] findNumerics(String[] valuse) {
        return Arrays.stream(valuse)
                .filter(value -> isNumerics(value))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    //사칙연산 메소드  + - / *
    public Integer add(String i, String j) {
        if (isNumerics(i, j)) {
            return Integer.parseInt(i) + Integer.parseInt(j);
        }
        return 0;
    }

    //사칙연산 메소드  -
    public Integer subtract(String i, String j) {
        if(isNumerics(i, j)) {
            return Integer.parseInt(i) - Integer.parseInt(j);
        }
        return 0;
    }
    public Integer multiply(String i, String j) {
        if(isNumerics(i, j)) {
            return Integer.parseInt(i) * Integer.parseInt(j);
        }
        return 0;
    }

    public Integer divide(String i, String j) {
        if(isNumerics(i, j)) {
            return Integer.parseInt(i) / Integer.parseInt(j);
        }
        return 0;
    }

    private boolean isNumerics(String ...values) {
        try {
            for (String value : values) {
                Integer.parseInt(value);
            }
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }




}

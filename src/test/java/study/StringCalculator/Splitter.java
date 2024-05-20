package study.StringCalculator;

public class Splitter {

    private final static String DELIMETER = " ";

    public static String[] splitString(String input) {
        return input.split(DELIMETER);
    }
}

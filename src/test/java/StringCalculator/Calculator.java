package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static String PLUS = "+";
    private static String SUBTRACT = "-";
    private static String MULTIPLY = "*";
    private static String DIVISION = "/";

    private ArrayList<String> intValues = new ArrayList<>();

    public void parseInt(String value){
        //숫자만 가져오도록
        Pattern regex = Pattern.compile("\\d+");
        Matcher regexMatcher = regex.matcher(value);

        while (regexMatcher.find()) {
            intValues.add(regexMatcher.group());
            System.out.println(intValues);
        }
    }

    public void parseForms(String value){
        //계산만 가져오도록
        String[] values = value.split(" ");

    }

    @DisplayName("덧셈")
    int add(int a, int b){
        return a+b;
    }

    @DisplayName("뺄셈")
    int subtract(int a, int b){
        return a-b;
    }

    @DisplayName("곱셈")
    int multiply(int a, int b){
        return a*b;
    }

    @DisplayName("나눗셈")
    int divide(int a, int b){
        return a/b;
    }

}

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String RETRY_NUMBER = "1";
    public static final String NOT_VALID = "NOT_VALID";
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public String getNumericInput() throws IOException {
        String input = br.readLine();
        if (!validateInput(input)) return NOT_VALID;
        return input;
    }

    public boolean validateInput(String input){
        if (input.length() != 3) return false;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            return false;
        }
        return isNotDuplicatedNumber(input);
    }

    private boolean isNotDuplicatedNumber(String input) {
        Set<Character> charSet = new HashSet<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            charSet.add(c);
        }
        return charSet.size() == 3;
    }

    public boolean getInput() throws IOException {
        String given = br.readLine();
        return given.equals(RETRY_NUMBER);
    }
}
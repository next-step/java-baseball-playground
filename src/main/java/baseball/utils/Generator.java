package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<Integer> makeUserNumber(String number) {
        Validator.checkIsNumber(number);
        List<Integer> numbers = new ArrayList<>();
        for (int cipher = 0; cipher < number.length(); cipher++) {
            numbers.add(getAnInt(number, cipher));
        }
        return numbers;
    }

    private static int getAnInt(String number, int cipher) {
        return Integer.parseInt(number.substring(cipher, cipher + 1));
    }
}

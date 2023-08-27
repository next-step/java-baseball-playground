package baseboll.myTrial.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberProvider {
    private int makeInteger() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);
        int firstDigit = digits.get(0);
        int secondDigit = digits.get(1);
        int thirdDigit = digits.get(2);
        return firstDigit * 100 + secondDigit * 10 + thirdDigit;
    }

    public String makeRandomAnswer(){
        return String.valueOf(this.makeInteger());
    }
}

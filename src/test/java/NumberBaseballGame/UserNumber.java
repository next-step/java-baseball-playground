package NumberBaseballGame;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private List<Integer> userNumbers;

    public UserNumber(int userNumbers) {
        this.userNumbers = new ArrayList<>();
        String strNumbers = String.valueOf(userNumbers);
        for(int i = 0; i < strNumbers.length(); i++) {
            this.userNumbers.add(Integer.parseInt(String.valueOf(strNumbers.charAt(i))));
        }
    }

    public List<Integer> getUserNumbers() { return userNumbers; }
}

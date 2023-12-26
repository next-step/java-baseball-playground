package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserNumbers {
    private final static int USER_NUMBER_SIZE = 3;
    Scanner scanner = new Scanner(System.in);
    private List<Integer> userInputNumbers = new ArrayList<>();

    public BaseballNumbers inputUserNumbers() {
        String[] strArr = scanner.next().split("");
        validateSize(strArr);
        for (int i = 0; i < USER_NUMBER_SIZE; i++) {
            userInputNumbers.add(Integer.valueOf(strArr[i]));
        }
        BaseballNumbers userNumbers = new BaseballNumbers(userInputNumbers);
        return userNumbers;
    }

    private static void validateSize(String[] strArr) {
        if (strArr.length != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void deleteUserInputNumbers (){
        userInputNumbers.clear();
    }
}
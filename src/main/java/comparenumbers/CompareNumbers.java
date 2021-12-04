package comparenumbers;

import java.util.List;

public class CompareNumbers {

    public int checkNumbers(List<Integer> comList, List<Integer> userList) {
        int ball = 0;
        for (int i = 0; i < userList.size(); i++) {
            ball = getBall(comList, userList, ball, i);
        }
        return ball;
    }

    private int getBall(List<Integer> comList, List<Integer> userList, int ball, int i) {
        if (comList.contains(userList.get(i))) {
            ball++;
        }
        return ball;
    }

    public int checkIndexNumber(List<Integer> comList, List<Integer> userList) {

        int strike = 0;
        for (int i = 0; i < userList.size(); i++) {
            strike = getStrike(comList, userList, strike, i);
        }
        return strike;
    }

    private int getStrike(List<Integer> comList, List<Integer> userList, int strike, int i) {
        if (comList.get(i).equals(userList.get(i))) {
            strike++;
        }
        return strike;
    }
}

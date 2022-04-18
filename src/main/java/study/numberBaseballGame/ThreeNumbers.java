package study.numberBaseballGame;

import java.util.List;

public class ThreeNumbers {

    private int first;
    private int second;
    private int third;

    public void insertExpectedThreeNumbers(String s) {
        first = Integer.parseInt(s.substring(0, 1));
        second = Integer.parseInt(s.substring(1, 2));
        third = Integer.parseInt(s.substring(2,3));
    }

    public void generateThreeRandomNumbers() {
        first = generateRandomNumber();
        second = generateRandomNumberWithoutBannedNumber(List.of(first));
        third = generateRandomNumberWithoutBannedNumber(List.of(first, second));
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 9) + 1;
    }

    private int generateRandomNumberWithoutBannedNumber(List<Integer> bannedNumberList) {
        int uniqueNumber = generateRandomNumber();
        while (bannedNumberList.contains(uniqueNumber)) {
            uniqueNumber = generateRandomNumber();
        }
        return uniqueNumber;
    }

    public void init() {
        first = 0;
        second = 0;
        third = 0;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }
}

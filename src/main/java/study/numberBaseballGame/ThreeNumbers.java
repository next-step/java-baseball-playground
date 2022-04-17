package study.numberBaseballGame;

import java.util.List;

public class ThreeNumbers {

    private int first;
    private int second;
    private int third;

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
}

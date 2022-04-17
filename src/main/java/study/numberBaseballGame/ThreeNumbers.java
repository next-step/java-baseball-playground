package study.numberBaseballGame;

import java.util.List;

public class ThreeNumbers {

    private int first;
    private int second;
    private int third;

    public ThreeNumbers insertExpectedThreeNumbers(String s) {
        assertInputString(s);
        first = Integer.parseInt(s.substring(0, 1));
        second = Integer.parseInt(s.substring(1, 2));
        third = Integer.parseInt(s.substring(2,3));
        return this;
    }

    private void assertInputString(String s) {
        if (s == null || s.length() != 3) throw new IllegalArgumentException("입력된 문자열의 길이가 3이 아닙니다.");
        if (!s.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(0) == s.charAt(2))
            throw new IllegalArgumentException("숫자 세 개는 서로 다른 숫자여야합니다..");
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
}

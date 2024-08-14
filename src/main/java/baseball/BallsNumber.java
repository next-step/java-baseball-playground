package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BallsNumber {

    public List<Integer> splitNumber(int userNumber) {
        List<Integer> userNumList = new ArrayList<>();

        while(userNumber > 0) {
            userNumList.add(0, userNumber % 10);
            userNumber /= 10;
        }

        return userNumList;
    }
    public static boolean validateNumber(List<Integer> ballNumbers) {
        return areAllNumbersValid(ballNumbers) && areAllNumbersUnique(ballNumbers);
    }

    // 1~9사이 숫자인지 확인

    private static boolean areAllNumbersValid(List<Integer> ballNumbers) {
        return ballNumbers.stream().allMatch(BallsNumber::isValidNumber);
    }
    private static boolean isValidNumber(int x) {
        if (!(0 < x && x < 10)) {
            System.out.println("1~9 사이 숫자로 이루어진 수를 입력해주세요.");
            return false;
        }
        return true;
    }
    // 숫자 중복 확인
    private static boolean areAllNumbersUnique(List<Integer> ballNumbers) {
        return ballNumbers.stream().allMatch(x -> isUniqueNumber(ballNumbers, x));
    }
    private static boolean isUniqueNumber(List<Integer> ballNumbers, int x) {
        if (!(Collections.frequency(ballNumbers, x) == 1)) {
            System.out.println("중복 숫자가 없는 수를 입력해주세요.");
            return false;
        }
        return true;

    }
}


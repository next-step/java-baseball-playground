package baseball.model;

import baseball.model.exceptions.BallsFormatException;
import baseball.model.exceptions.InputFormatException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Balls {
    private static final int MAX_RANGE = 9;
    private static final int MIN_RANGE = 1;
    private List<Ball> balls = new ArrayList<>();

    public Balls(String input) throws BallsFormatException,InputFormatException {
        List<Integer> numberList = changeToIntegers(input);
        numberList.forEach((s) -> balls.add(new Ball(numberList.indexOf(s), s)));

    }

    public Balls(List<Integer> numberList) {
        numberList.forEach((s) -> balls.add(new Ball(numberList.indexOf(s), s)));
    }

    private static List<Integer> changeToIntegers(String input) {
        String[] numbers = input.split("");
        List<Integer> list = Arrays.stream(numbers).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        return list;
    }


    public static boolean validateNumbers(String input) throws BallsFormatException,InputFormatException {

        if (input.length() != 3) {
            throw new InputFormatException("3자리의 값을 입력해주세요.");
        }

        List<Integer> numberList = changeToIntegers(input);

        boolean overlapStatus = isOverlaped(numberList);
        boolean overRangeStatus = isOverrange(numberList);

        if (overlapStatus) {
            throw new BallsFormatException("중복값이 발생했습니다.");
        }
        if (overRangeStatus) {
            throw new BallsFormatException("1~9 사이의 숫자가 아닙니다.");
        }
        return true;
    }

    private static boolean isOverlaped(List<Integer> numberList) {
        int length = (int) numberList.stream().distinct().count();
        return !(length == 3);
    }

    private static boolean isOverrange(List<Integer> numberList) {
        return numberList.stream().anyMatch(s -> (s > MAX_RANGE || s < MIN_RANGE));
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}

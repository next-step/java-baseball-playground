package baseball.domain;

import baseball.exception.BallNumberSizeException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    public static final int NUMBER_COUNT = 3;

    private List<Ball> ballList;

    public Balls(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new BallNumberSizeException("3자리 숫자를 입력하세요.");
        }

        List<Integer> numbers = mapList(input);
        if (numbers.size() != NUMBER_COUNT) {
            throw new BallNumberSizeException("3자리 숫자를 입력하세요.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("각 숫자가 중복되지 않게 입력하세요.");
        }

        ballList = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            ballList.add(new Ball(i + 1, numbers.get(i)));
        }
    }

    private List<Integer> mapList(String numberString) {
        List<Integer> numbers = new ArrayList<>();
        char[] numberCharacters = numberString.toCharArray();
        for (char numberCharacter : numberCharacters) {
            numbers.add(Integer.parseInt(Character.toString(numberCharacter)));
        }

        return numbers;
    }

    public BallStatus play(Ball input) {
        return ballList.stream()
                .map(ball -> ball.play(input))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}

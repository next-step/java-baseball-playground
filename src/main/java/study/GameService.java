package study;

import java.util.Arrays;

public class GameService {

    public Game makeGame() {
        return new Game();
    }

    public void setRandomNumber(Game game) {
        game.numbers[0] = (int) (Math.random() * 9) + 1;
        game.numbers[1] = (int) (Math.random() * 9) + 1;
        game.numbers[2] = (int) (Math.random() * 9) + 1;
    }

    public boolean isDoneGame(Status[] statuses) {
        return (int) Arrays.stream(statuses).filter(status -> status == Status.STRIKE).count() == 3;
    }

    public Status[] compareWithUserInput(Game game, String input) {

        Status[] statuses = new Status[3];
        for (int i = 0; i < 3; i++)
            statuses[i] = compareIndexOfGame(game, input, i);

        return statuses;
    }

    private Status compareIndexOfGame(Game game, String input, int index) {
        if (isStrike(game, index, getNumberOfIndex(input, index)))
            return Status.STRIKE;

        if (isBall(game, index, getNumberOfIndex(input, index)))
            return Status.BALL;

        return Status.NOTHING;
    }

    private int getNumberOfIndex(String input, int index) {
        return input.charAt(index) - '0';
    }

    private boolean isStrike(Game game, int index, int userNumber) {
        return (game.numbers[index] == userNumber);
    }

    private boolean isBall(Game game, int index, int userNumber) {
        return !isStrike(game, index, userNumber) && containsNumberInArray(game.numbers, userNumber);
    }

    private boolean containsNumberInArray(int[] numbers, int userNumber) {
        return Arrays.stream(numbers).filter(n -> n == userNumber).count() == 1;
    }

}

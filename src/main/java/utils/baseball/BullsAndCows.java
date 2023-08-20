package utils.baseball;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BullsAndCows {
    private int numberLength = 3;
    private int[] computerNumbers = new int[numberLength];

    private int strikeCount = 0;
    private int ballCount = 0;

    public static BullsAndCows makeNewGame() {
        return new BullsAndCows();
    }

    private BullsAndCows() {}

    public int getNumberLength() {
        return numberLength;
    }
    public int[] getComputerNumbers() {
        return computerNumbers;
    }
    public int getStrikeCount() {
        return strikeCount;
    }
    public int getBallCount() {
        return ballCount;
    }

    public void setComputerNumbers(int[] computerNumbers) {
        this.computerNumbers = computerNumbers;
    }
    private void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
    private void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void progressGameRound(String inputValue) {
        int[] playerNumbers = convertToPlayerNumbers(inputValue);
        int strikeCount = countStrike(playerNumbers);
        int ballCount = countBall(playerNumbers);
        setStrikeCount(strikeCount);
        setBallCount(ballCount);
    }

    public void resetComputerNumbers() {
        int[] computerNumbers = generateComputerNumbers();
        setComputerNumbers(computerNumbers);
    }

    private int[] generateComputerNumbers() {
         return IntStream.range(0, numberLength)
                .map(i -> (int) (Math.random() * 10))
                .toArray();
    }

    private int[] convertToPlayerNumbers(String inputValue) {
        String[] inputValues = inputValue.split("");
        return Stream.of(inputValues)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int countBall(int[] playerNumbers) {
        int sameNumberCount = countSameNumber(playerNumbers);
        int strikeCount = countStrike(playerNumbers);
        return sameNumberCount - strikeCount;
    }

    private int countSameNumber(int[] playerNumbers) {
        long count = Arrays.stream(computerNumbers)
                .filter(num -> Arrays
                        .stream(playerNumbers)
                        .anyMatch(playerNum -> playerNum == num))
                .count();
        return (int) count;
    }

    private int countStrike(int[] playerNumbers) {
        long strikeCount = IntStream.range(0, computerNumbers.length)
                .filter(i -> computerNumbers[i] == playerNumbers[i])
                .count();
        return (int) strikeCount;
    }

    public boolean isAllStrike() {
        if(strikeCount == numberLength) {
            return true;
        }
        return false;
    }

    public boolean isNothing() {
        if(strikeCount + ballCount == 0) {
            return true;
        }
        return false;
    }

    public void handleReplayGame(String inputOption) {
       if(shouldReplayGame(inputOption)) {
           resetComputerNumbers();
       }
    }

    public boolean shouldReplayGame(String inputOption) {
        int option = Integer.parseInt(inputOption);
        return option == 1;
    }
}

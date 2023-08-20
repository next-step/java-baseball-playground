package utils;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BullsAndCows {
    private static Scanner scanner = new Scanner(System.in);

    private int numberLength = 3;

    private int[] computerNumbers = new int[numberLength];
    private int[] playerNumbers = new int[numberLength];
    private Boolean[] areStrike = new Boolean[numberLength];

    private BullsAndCows(String inputValue) {
        setNumbers();
        setPlayerNumbers(inputValue);
        setAreStrike();
    }

    public static void gameStart(String inputValue) {
        BullsAndCows game = new BullsAndCows(inputValue);

    }

    public static String getInputValue() {
        System.out.print("숫자를 입력해 주세요:");
        return scanner.nextLine();
    }


    private static String getInputOption() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextLine();
    }

    public void progressGameRound(String input) {
        setGameRound(input);
        printResult();
        stopRun();
    }

    private void stopRun() {
        if( isAllStrike(getStrikeCount()) ) {
            run = false;
            getInputOption();
        }
    }

    private void setGameRound(String inputValues) {
        setPlayerNumbers(inputValues);
        setAreStrike();
    }

    private void setNumbers() {
        for (int i=0; i<computerNumbers.length ; i++) {
            computerNumbers[i] = (int)(Math.random()*10);
        }
    }

    private void setPlayerNumbers(String inputValue) {
        validateInputValue(inputValue);
        String[] inputValues = inputValue.split("");
        this.playerNumbers = Stream.of(inputValues)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void validateInputValue(String inputValue) {
        Pattern pattern = Pattern.compile("\\b([0-9][0-9][0-9])\\b");
        Matcher matcher = pattern.matcher(inputValue);
        if(!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

    private void setAreStrike() {
        for(int i=0; i<numbers.length; i++) {
            areStrike[i] = numbers[i] == playerNumbers[i];
        }
    }

    private static void validateGameProgressOptions(String inputOption) {
        Pattern pattern = Pattern.compile("\\b([0-1])\\b");
        Matcher matcher = pattern.matcher(inputOption);
        if(!matcher.find()) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

    public void printResult() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();
        String result = getResult(strikeCount, ballCount);

        if(isAllStrike(strikeCount)) {
            result += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        }
        System.out.print(result);
    }


    public String getResult(int strikeCount, int ballCount) {
        String result = strikeCount + ballCount == 0 ?  "낫싱" : "";
        if(strikeCount > 0) {
           result +=  strikeCount + "스트라이크";
        }
        if(ballCount > 0) {
            result += ballCount + "볼";
        }
        else if(isAllStrike(strikeCount)) {
            result = numberLength + "스트라이크";
        }
        return result;
    }

    public int getStrikeCount() {
        long count = Arrays.stream(this.areStrike)
                .filter(isStrike -> isStrike)
                .count();
        return (int) count;
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int i=0; i<numbers.length; i++) {
            if(!areStrike[i] && isBall(numbers[i])) {
              ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(int expected) {
        return Arrays.stream(playerNumbers)
                .anyMatch(number -> number == expected);
    }

    private boolean isAllStrike(int strikeCount) {
        return strikeCount == numberLength ? true : false;
    }
}

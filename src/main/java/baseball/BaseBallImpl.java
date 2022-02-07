package baseball;

import java.util.*;

public class BaseBallImpl implements BaseBall{
    private static final int  GAME_SIZE = 3;
    private  String result;
    private int strike;
    private int ball;

    @Override
    public boolean resultValue() {
        if (strike == GAME_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return false;
    }

    @Override
    public void inputValue(String value) {
        System.out.println("value = " + value);
        checkValue(value);
    }

    private void checkValue(String value) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            checkStrikeOrBall(value, i);
        }
    }

    private void checkStrikeOrBall(String value, int i) {
        String valueOf = String.valueOf(value.charAt(i));
        String resultOf = String.valueOf(result.charAt(i));
        if (resultOf.equals(valueOf)) {
            strike += 1;
        }
        if (!resultOf.equals(valueOf)
                && result.contains(valueOf)) {
            ball += 1;
        }
    }

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String next = scanner.next();
            this.inputValue(next);
        } while (!this.resultValue());
    }

    public void setResult() {
        String [] resultList = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.result = "";
        do {
            int temp = (int) (Math.random() * 100) % resultList.length;
            checkDuplicated(resultList, temp);
        } while (result.length() < 4);
    }

    private void checkDuplicated(String[] resultList, int temp) {
        if (!result.contains(resultList[temp])) {
            result += resultList[temp];
        }
    }

    public BaseBallImpl() {
        setResult();
    }
}

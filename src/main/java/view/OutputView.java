package view;

import checker.CountVO;

public class OutputView {
    private static final String PROMPT_INPUT = "숫자를 입력해주세요";
    private static final String PROMPT_VALID_INPUT = "세 개의 서로 다른 숫자를 입력하세요";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String STRIKE_AND_BALL_MESSAGE = "%d스트라이크, %d볼";
    private static final String MORE_GAME_PROMPT = "한번 더 하시려면 1, 종료하려면 2를 입력하세요";

    public void printGetInputNumbers() {
        System.out.println(PROMPT_INPUT);
    }

    public void printResult(CountVO countVO) {
        if (isCorrect(countVO)) {
            printCorrectMessage();
            return;
        }
        if (countVO.isNothing()) {
            printNothingMessage();
            return;
        }
        if (countVO.isNoStrike()) {
            printBallMessage(countVO.getBallCount());
            return;
        }
        if (countVO.isNoBall()) {
            printStrikeMessage(countVO.getStrikeCount());
            return;
        }
        printStrikeAndBallMessage(countVO.getStrikeCount(), countVO.getBallCount());
    }

    public boolean validCheck(String input){
        if (input.equals(InputView.NOT_VALID)){
            System.out.println(PROMPT_VALID_INPUT);
            return false;
        }
        return true;
    }

    private boolean isCorrect(CountVO countVO) {
        return countVO.isCorrect();
    }

    private void printCorrectMessage() {
        System.out.println(CORRECT_MESSAGE);
    }

    private void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void printStrikeMessage(int strikeCount) {
        System.out.println(String.format(STRIKE_MESSAGE, strikeCount));
    }

    private void printBallMessage(int ballCount) {
        System.out.println(String.format(BALL_MESSAGE, ballCount));
    }

    private void printStrikeAndBallMessage(int strikeCount, int ballCount) {
        System.out.println(String.format(STRIKE_AND_BALL_MESSAGE, strikeCount, ballCount));
    }

    public void moreGame() {
        System.out.println(MORE_GAME_PROMPT);
    }
}
public class Baseball {
    static final int TOTAL_NUMBERS = 3;
    static final int ON = 1;
    private final InputView inputView;
    private final OutputView outputView;
    private final BallStrikeStatus ballStrikeStatus;
    private int gameStatus = ON;
    private String solution;


    public Baseball(InputView inputView, OutputView outputView, BallStrikeStatus ballStrikeStatus) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballStrikeStatus = ballStrikeStatus;
    }

    // gameStatus 필드값이 1일때만 계속 게임을 진행.
    // 숫자를 맞춘 뒤 2를 입력하면 게임이 종료됨
    private boolean isGameRunning() {
        return gameStatus == ON;
    }

    // while문으로 본격적인 게임을 진행하기 전에, setSolution을 이용하여
    // 정답을 정해두고 시작함.
    public void playGames() {
        setSolution();
        while (isGameRunning()) {
            String input = inputView.getInputNumber();
            outputView.printMessage(ballStrikeStatus.getResultMessage(solution, input));
            endOrRestartGameIfStrikeOut();
        }
    }

    // 게임이 종료되면(:삼진 아웃), 입력을 받아 gameStatus를 결정하며,
    // 기존의 정답을 다시 초기화하여 설정함.
    private void endOrRestartGameIfStrikeOut() {
        if (isGameEnded()) {
            gameStatus = inputView.restartOrExit();
            setSolution();
        }
    }

    //구현된 RandomNumber 클래스를 이용하여, 문자열로 된 정답을 설정한다.
    private void setSolution() {
        final RandomNumber randomNumber = new RandomNumber();
        this.solution = randomNumber.getRandomNumber();
    }

    // 삼진 아웃인 경우, 게임 종료 메시지를 보낸 뒤 게임이 종료되었다고 알림
    private boolean isGameEnded() {
        if (ballStrikeStatus.isStrikeOut(TOTAL_NUMBERS)) {
            outputView.printGameEndMessage();
            return true;
        }
        return false;
    }
}


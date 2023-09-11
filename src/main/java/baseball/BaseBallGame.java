package baseball;

import java.util.List;

public class BaseBallGame {
    private static final int TOTAL_BALLS = 3;
    private static final int ON = 1;
    private final View view;
    private List<Ball> answer;
    private int status;

    public BaseBallGame(View view) {
        this.view = view;
        resetAnswer();
    }

    public void game() {
        changeGameStatus(ON);

        while (isRunning()) {
            List<Ball> submit = getSubmit();
            playGame(answer, submit);
        }
    }

    private boolean isRunning() {
        return status == ON;
    }

    private void playGame(List<Ball> answer, List<Ball> submit) {
        PitchResult result = new Pitch(answer, submit).getPitchResult();
        view.printMessage(result.report());

        if (result.isStrikeOut(TOTAL_BALLS)) {
            processWhenStrikeOut(result);
        }
    }

    private void processWhenStrikeOut(PitchResult pitchResult) {
        view.printStrikeOutMessage(TOTAL_BALLS);
        view.printCheckToRestartMessage();
        changeGameStatus(view.getOrderNumber());
        resetAnswer();
    }

    private List<Ball> getSubmit() {
        view.printNumberInputMessage();
        String userInput = view.getInputNumber();
        return new Balls(new InputNumberSupplier(userInput)).getBallList();
    }

    private void resetAnswer() {
        Balls computer = new Balls(new RandomNumberSupplier(TOTAL_BALLS));
        this.answer = computer.getBallList();
    }

    private void changeGameStatus(int status) {
        this.status = status;
    }


}
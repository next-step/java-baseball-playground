package baseball;

import java.util.List;

public class BaseBallGame {
    private static final int TOTAL_BALLS = 3;
    private static final int ON = 1;
    private final View view;
    private int status;

    public BaseBallGame(View view) {
        this.view = view;
    }

    public void game() {
        Balls computer = new Balls(new RandomNumberSupplier(TOTAL_BALLS));
        List<Ball> computerBalls = computer.getBallList();
        status = ON;

        while (status == ON) {
            view.printNumberInputMessage();
            String userInput = view.getInputNumber();
            List<Ball> userBalls = new Balls(new InputNumberSupplier(userInput)).getBallList();
            PitchResult result = new Pitch(computerBalls, userBalls).getPitchResult();
            view.printMessage(result.report());

            if (result.isStrikeOut(TOTAL_BALLS)) {
                processWhenStrikeOut(TOTAL_BALLS);
                computerBalls = computer.getBallList();
            }
        }
    }

    public void processWhenStrikeOut(int totalBalls) {
        view.printStrikeOutMessage(totalBalls);
        view.printCheckToRestartMessage();
        changeGameOnOFF(view.getOrderNumber());
    }

    public void changeGameOnOFF(int order) {
        this.status = order;
    }
}

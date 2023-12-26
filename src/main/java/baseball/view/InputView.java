package baseball.view;


public class InputView {
    private String PRINT_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private String PRINT_INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printInputNumbersMessage() {
        System.out.print(PRINT_INPUT_NUMBERS_MESSAGE);
    }

    public void printInputGameRestartMessage(int strike) {
        System.out.print(PRINT_INPUT_GAME_RESTART_MESSAGE);
    }
}
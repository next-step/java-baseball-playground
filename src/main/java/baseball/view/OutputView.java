package baseball.view;


public class OutputView {
    private String PRINT_START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";


    public void printStartGameMessage() {
        System.out.println(PRINT_START_GAME_MESSAGE);
    }

    public void printRefereeMessage(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike == 1) {
            System.out.println("1스트라이크");
        }
        if (ball == 0 && strike == 2) {
            System.out.println("2스트라이크");
        }
        if (ball == 1 && strike == 0) {
            System.out.println("1볼");
        }
        if (ball == 1 && strike == 1) {
            System.out.println("1볼 1스트라이크");
        }
        if (ball == 1 && strike == 2) {
            System.out.println("1볼 2스트라이크");
        }
        if (ball == 2 && strike == 0) {
            System.out.println("2볼");
        }
        if (ball == 2 && strike == 1) {
            System.out.println("2볼 1스트라이크");
        }
        if (ball == 3 && strike == 2) {
            System.out.println("3볼");
        }
        if (ball == 0 && strike == 3) {
            System.out.println("3스트라이크" + "\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
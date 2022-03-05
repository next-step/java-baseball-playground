package NumberBaseballGame;

public class ResultView {
    public void printMessage(NumberChecker numberChecker) {
        if(numberChecker.getBallCount() == 0 &&
                numberChecker.getStrikeCount() == 0) {
            System.out.println("낫싱");
            return;
        }
        if(numberChecker.getBallCount() == 0 &&
                numberChecker.getStrikeCount() > 0) {
            System.out.printf("%d스트라이크\n", numberChecker.getStrikeCount());
            return;
        }
        if(numberChecker.getBallCount() > 0 &&
                numberChecker.getStrikeCount() == 0) {
            System.out.printf("%d볼\n", numberChecker.getBallCount());
            return;
        }
        if(numberChecker.getBallCount() > 0 &&
                numberChecker.getStrikeCount() > 0) {
            System.out.printf("%d볼 %d스트라이크\n",
                    numberChecker.getBallCount(), numberChecker.getStrikeCount());
        }
    }
}

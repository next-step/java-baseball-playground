package checker;

public class BaseballChecker {
    private static final int NUMBER_LENGTH = 3;
    private CountVO countVO;
    private final String targetNumber;

    public BaseballChecker(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public CheckEnum checkGuess(String slicedGenerated, String given) {
        if (slicedGenerated.equals(given)) return CheckEnum.STRIKE;
        if (this.targetNumber.contains(given)) return CheckEnum.BALL;
        return CheckEnum.NOTHING;
    }

    public void evaluateGuess(String guess) {
        countVO = new CountVO();
        for (int i = 1; i <= NUMBER_LENGTH; i++) {
            String generatedDigit = targetNumber.substring(i - 1, i);
            String guessedDigit = guess.substring(i - 1, i);
            CheckEnum checkEnum = this.checkGuess(generatedDigit, guessedDigit);
            updateCount(checkEnum);
        }
    }

    private void updateCount(CheckEnum checkEnum) {
        if (checkEnum == CheckEnum.STRIKE) {
            countVO.increaseStrikeCount();
            return;
        }
        if (checkEnum == CheckEnum.BALL) {
            countVO.increaseBallCount();
        }
    }

    public CountVO getResult() {
        return this.countVO;
    }
}

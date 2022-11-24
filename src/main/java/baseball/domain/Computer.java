package baseball.domain;

import baseball.RandomListGenerator;
import java.util.List;

public class Computer {
    final private List<Integer> numbers;

    public Computer(RandomListGenerator randomListGenerator) {
        numbers = randomListGenerator.generate();
    }

    public HintManager calculateHint(List<Integer> userNumbers) {
        HintManager hintManager = new HintManager();

        for (int cipher = 0; cipher < userNumbers.size(); cipher++) {
            int userNumber = userNumbers.get(cipher);
            findHint(hintManager, userNumber, cipher);
        }

        return hintManager;
    }

    private void findHint(HintManager hintManager, Integer userNumber, int cipher) {
        boolean isContain = checkContain(userNumber);
        if (isContain) {
            checkStrike(hintManager, userNumber, cipher);
            checkBall(hintManager, userNumber, cipher);
        }
    }

    private boolean checkContain(Integer userNumber) {
        return numbers.contains(userNumber);
    }

    private void checkStrike(HintManager hintManager, Integer userNumber, int cipher) {
        int computerNumber = numbers.get(cipher);
        if (computerNumber == userNumber) {
            hintManager.updateStrike();
        }
    }

    private void checkBall(HintManager hintManager, Integer userNumber, int cipher) {
        int computerNumber = numbers.get(cipher);
        if (computerNumber != userNumber) {
            hintManager.updateBall();
        }
    }
}

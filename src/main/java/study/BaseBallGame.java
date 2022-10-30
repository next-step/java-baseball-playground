package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseBallGame {
    private final Random random = new Random();
    private int[] goals;
    private Map<Integer, Boolean> numberMap;

    public BaseBallGame(int[] goals) {
        init(goals);
    }

    public BaseBallGame() {
        initRandomNumbers();
    }

    private void init(int[] goals) {
        this.goals = goals;
        numberMap = new HashMap<>();
        for (int goal : goals) {
            numberMap.put(goal, true);
        }
    }

    private void initRandomNumbers() {
        int[] randomNums = new int[3];
        numberMap = new HashMap<>();
        for (int i = 0; i < randomNums.length; i++) {
            while (true) {
                int randomNum = random.nextInt(9) + 1;
                if (numberMap.containsKey(randomNum)) {
                    continue;
                }
                randomNums[i] = randomNum;
                numberMap.put(randomNums[i], true);
                break;
            }
        }
        this.goals = randomNums;
    }

    public void startGame() {
        while (true) {
            int[] answers = InputView.takeInput();
            if (ResultView.isNotThreeStrike(checkAnswer(answers))) {
                continue;
            }
            if (ResultView.isEndGame()) {
                break;
            }
            initRandomNumbers();
        }
    }

    BaseBallGameResult checkAnswer(int[] answers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answers.length; i++) {
            if (goals[i] == answers[i]) {
                strike++;
                continue;
            }
            if (isContainNumberMap(answers[i])) {
                ball++;
            }
        }
        return new BaseBallGameResult(strike, ball);
    }

    private boolean isContainNumberMap(int number) {
        return numberMap.getOrDefault(number, false);
    }

}

public class BallStrikeStatus {
    private int ballCount;
    private int strikeCount;

    public String getResultMessage(String solution, String input) {
        resetBallAndStrikeCount();
        updateBallAndStrikeCount(solution,input);

        if (ballCount != 0 && strikeCount != 0) {
            return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        }
        if (ballCount == 0 && strikeCount != 0) {
            return String.format("%d스트라이크", strikeCount);
        }
        if (ballCount != 0) {
            return String.format("%d볼", ballCount);
        }
        return "낫싱";
    }

    private void updateBallAndStrikeCount(String solution, String input) {
        for (int i = 0; i < Baseball.TOTAL_NUMBERS; i++) {
            updateCount(solution, solution.charAt(i), input.charAt(i));
        }
    }

    // 스트라이크, 볼 점수를 초기화 함
    private void resetBallAndStrikeCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    // 두 문자열의 i번째 문자를 받아, 같으면 strike
    // 서로 다르면서, 정답지가 입력의 문자를 포함하면 ball
    private void updateCount(String solution, char solWord, char inputWord) {
        if (solWord == inputWord) {
            strikeCount++;
        } else if (solution.contains(String.valueOf(inputWord))) {
            ballCount++;
        }
    }

    public boolean isStrikeOut(int totalNumber) {
        return totalNumber == strikeCount;
    }
}

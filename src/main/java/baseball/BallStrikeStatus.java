package baseball;

public class BallStrikeStatus {
    private int ballCount;
    private int strikeCount;

    public String getResultMessage(String solution, String input) {
        // 볼, 스트라이크 횟수를 0으로 초기화
        resetBallAndStrikeCount();
        // 주어진 정답과 입력을 기반으로, 볼, 스트라이크 횟수를 업데이트
        updateBallAndStrikeCount(solution,input);

        //업데이트된 볼, 스트라이크 횟수를 기반으로 출력 메시지를 결정.
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

    // 스트라이크, 볼 점수를 초기화 함
    private void resetBallAndStrikeCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    private void updateBallAndStrikeCount(String solution, String input) {
        for (int i = 0; i < Baseball.TOTAL_NUMBERS; i++) {
            updateCount(solution, solution.charAt(i), input.charAt(i));
        }
    }

    // 두 문자열의 i번째 문자를 받아, 같으면 strike
    // 서로 다르면서, 정답이 입력의 문자를 포함하면 ball
    private void updateCount(String solution, char solWord, char inputWord) {
        if (solWord == inputWord) {
            strikeCount++;
        } else if (solution.contains(String.valueOf(inputWord))) {
            ballCount++;
        }
    }

    // 총 볼의 갯수( 문제에서는 3 )을 받아, 삼진 아웃 여부를 확인함!
    public boolean isStrikeOut(int totalNumber) {
        return totalNumber == strikeCount;
    }
}

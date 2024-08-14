package ui;

import baseball.Score;

public class ResultView {
    public static int result(Score score) {
        StringBuilder sb = new StringBuilder();
        int result = 0;

        if(score.isNothing()) {
            sb.append("낫싱");
        }
        if(score.getBall() > 0) {
            sb.append(score.getBall()).append("볼 ");
        }
        if(score.getStrike() > 0){
            sb.append(score.getStrike()).append("스트라이크");
            result = score.getStrike();
        }
        if(score.isGameEnd()) {
            sb.append("\n")
                    .append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append("\n")
                    .append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        System.out.println(sb);

        return result;
    }
}

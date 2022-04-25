package baseball;

public class ResultView {

    public static void result(PlayResult play) {
        StringBuilder sb = new StringBuilder();
        sb.append(play.getBall()).append("볼 ");
        sb.append(play.getStrike()).append("스트라이크");

        System.out.println(sb.toString());
    }

    public void gameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

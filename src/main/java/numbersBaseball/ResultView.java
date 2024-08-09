package numbersBaseball;

public class ResultView {
    public static String scoreResult(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if(ball != 0) sb.append(ball).append("볼 ");
        if(strike != 0) sb.append(strike).append("스트라이크");
        if(ball == 0 && strike == 0) return "낫싱";

        return sb.toString();
    }

    public static void ending() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

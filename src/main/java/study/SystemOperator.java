package study;


public class SystemOperator {

    public static boolean isCorrect(ResultDTO result) {
        if (result.strikeValue == 3) {
            System.out.println(result.strikeValue+ "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 새 게임은 1, 종료는 2");
            return true;
        }

        if (result.strikeValue == 0 && result.ballValue == 0) {
            System.out.println("nothing");
        }
        if (result.strikeValue < 3 && result.strikeValue > 0) {
            System.out.println(result.getStrikeValue()+ "스트라이크");
        }
        if (result.ballValue > 0) {
            System.out.println(result.getBallValue()+ "볼");
        }
        return false;
    }
}

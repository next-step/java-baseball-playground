package study.baseballfortdd;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayResult {
    public int compare(List<Ball> computerBalls, List<Ball> userBalls) {
        // 0,1 반환 스트라이크면 0이고 아니면 3임
        int strike = coutStrike(computerBalls,userBalls);

        if(strike == 3){
            System.out.println(BallMessage.HOMERUN);
            return 3;
        }

        if(strike < 3){
            int ball = countBall(computerBalls,userBalls);
            // 나를 제외하고 어떻게 해야할지 모르겠네
            System.out.println("Strike : " + strike  + " Ball : " + ball + " Nothing : " + (3 - (strike + ball)));
        }

        return 1;
    }

    public int countBall(List<Ball> computerBalls, List<Ball> userBalls){
        return computerBalls.stream()
                            .filter(computerBall -> userBalls.stream()
                                                            .anyMatch(useball -> useball.getBallNumber().equals(computerBall.getBallNumber())
                                                                                    && !useball.getPosition().equals(computerBall.getPosition())))
                            .collect(Collectors.toList()).size();
    }

    public int coutStrike(List<Ball> computerBalls, List<Ball> userBalls){
        return computerBalls.stream()
                .filter( computer -> userBalls.stream().anyMatch(Predicate.isEqual(computer)))
                .collect(Collectors.toList()).size();
    }
}

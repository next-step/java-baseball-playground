package newBaseball;

import java.util.List;

public class Pitch {
    private final List<Ball> computerBalls;
    private final List<Ball> userBalls;

    Pitch(List<Ball> computerBall, List<Ball> userBall) {
        this.computerBalls = computerBall;
        this.userBalls = userBall;
    }

    public PitchResult getPitchResult() {
        PitchResult result = new PitchResult();

        computerBalls.stream()
                .flatMap(computerBall -> userBalls.stream()
                        .map(computerBall::getResult)
                        .filter(pitchStatus -> !pitchStatus.isNothing()))
                .forEach(result::updateCount);
        return result;
    }
}

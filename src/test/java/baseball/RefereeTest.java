package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    @DisplayName("스트라이크 테스트")
    void checkStrike() {
        Balls answerBall = new Balls("123");
        Balls userBall = new Balls("145");
        assertThat(Referee.judgement(answerBall, userBall)).isFalse();
    }

    @Test
    @DisplayName("볼 테스트")
    void checkBall() {
        Balls answerBall = new Balls("123");
        Balls userBall = new Balls("245");
        assertThat(Referee.judgement(answerBall, userBall)).isFalse();
    }

    @Test
    @DisplayName("낫싱 테스트")
    void checkNothing() {
        Balls answerBall = new Balls("123");
        Balls userBall = new Balls("456");
        assertThat(Referee.judgement(answerBall, userBall)).isFalse();
    }
}

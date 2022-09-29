package baseball;

import baseball.domain.Batter;
import baseball.domain.Pitcher;
import baseball.domain.Referee;
import org.junit.jupiter.api.Test;

import static baseball.domain.Pitcher.BALL_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ApplicationTest {

    @Test
    void 투수_테스트() {
        Pitcher pitcher = new Pitcher();
        String ball = pitcher.throwBall();
        assertThat(ball.length()).isEqualTo(BALL_LENGTH);
    }

    @Test
    void 타자_테스트() {
        Batter batter = new Batter();
        assertThatThrownBy(() -> batter.lengthCheck("32")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> batter.validStringCheck("310")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> batter.duplicateCheck("331")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 심판_테스트() {
        Referee referee = new Referee();
        String ball = "713";
        String swing = "123";
        String judgment = referee.judge(ball,swing);
        String result = "1볼 1스트라이크";
        assertThat(judgment).isEqualTo(result);
    }
}
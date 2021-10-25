package baseball.domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RefereeTest {

    private static final List<Integer> COMPUTER = Arrays.asList(1,2,3);
    Referee referee = new Referee();
    Judgement judgement = new Judgement();

    @Test
    void threeStrike() {
        String result = referee.compare(COMPUTER, Arrays.asList(1,2,3));
        assertThat(result).isEqualTo("0 볼 3 스트라이크");
    }

    @Test
    void out() {
        String result = referee.compare(COMPUTER, Arrays.asList(4,5,6));
        assertThat(result).isEqualTo("out");
    }

    @Test
    void ball1_strike1() {
        String result = referee.compare(COMPUTER, Arrays.asList(1,3,5));
        assertThat(result).isEqualTo("1 볼 1 스트라이크");
    }
}

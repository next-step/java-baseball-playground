package gameResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class StrikeCountServiceTest {
    StrikeCountService strikeCountService;

    @BeforeEach
    public void setUp() {
        strikeCountService = new StrikeCountService();
    }

    @Test
    @DisplayName("0스트라이크 카운트 테스트")
    public void countStrike() {
        int [] answer = {1,2,3};
        int [] input = {4,5,6};
        int strike = 0;

        assertThat(strike).isEqualTo(strikeCountService.countStrike(answer, input));
    }

    @Test
    @DisplayName("1스트라이크 카운트 테스트")
    public void countStrike_oneStrike() {
        int [] answer = {1,2,3};
        int [] input = {1,5,6};
        int strike = 1;

        assertThat(strike).isEqualTo(strikeCountService.countStrike(answer, input));
    }

    @Test
    @DisplayName("2스트라이크 카운트 테스트")
    public void countStrike_twoStrike() {
        int [] answer = {1,2,3};
        int [] input = {1,5,3};
        int strike = 2;

        assertThat(strike).isEqualTo(strikeCountService.countStrike(answer, input));
    }

    @Test
    @DisplayName("3스트라이크 카운트 테스트")
    public void countStrike_threeStrike() {
        int [] answer = {1,2,3};
        int [] input = {1,2,3};
        int strike = 3;

        assertThat(strike).isEqualTo(strikeCountService.countStrike(answer, input));
    }

    @Test
    @DisplayName("스트라이크 여부 확인_스트라이크인 경우")
    public void checkStrike_strike() {
        int answerElement = 1;
        int inputElement = 1;

        assertThat(1).isEqualTo(strikeCountService.checkStrike(answerElement, inputElement));
    }

    @Test
    @DisplayName("스트라이크 여부 확인_스트라이크 아닌 경우")
    public void checkStrike_notStrike() {
        int answerElement = 1;
        int inputElement = 3;

        assertThat(0).isEqualTo(strikeCountService.checkStrike(answerElement, inputElement));
    }
}

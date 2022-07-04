package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ResultViewTest {

    @ParameterizedTest
    @CsvSource(value = {"10:1볼", "11:1볼 1스트라이크", "03:3스트라이크"}, delimiter = ':')
    @DisplayName("볼과 스트라이크 개수에 따라 게임 결과를 정확히 출력하는지 확인한다")
    void checkGameResultMessage(String ballStrike, String expected) {
        int ball = Integer.parseInt(String.valueOf(ballStrike.charAt(0)));
        int strike = Integer.parseInt(String.valueOf(ballStrike.charAt(1)));

        ResultView resultView = new ResultView();
        String actual = resultView.makeGameResultMessage(ball, strike);

        assertThat(actual).isEqualTo(expected);
    }
}

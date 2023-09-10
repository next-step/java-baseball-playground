package baseball;

import baseball.BallStrikeStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class BallStrikeStatusTest {
    BallStrikeStatus ballStrikeStatus;

    @BeforeEach
    void setUp() {
        ballStrikeStatus = new BallStrikeStatus();
    }

    @ParameterizedTest
    @CsvSource(value = {"213:2볼 1스트라이크", "153:2스트라이크", "456:낫싱", "312:3볼"}, delimiter = ':')
    @DisplayName("입력에 대해, 정상적인 결과 메시지를 출력하는지를 확인합니다.")
    void getResultMessage_isCorrectOutput_true(String input, String result) {
        String solution = "123";
        assertThat(ballStrikeStatus.getResultMessage(solution, input)).isEqualTo(result);
    }
}
package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    Referee referee = new Referee();

    @ParameterizedTest
    @DisplayName("숫자 야구 게임이 올바로 진행되는지 Referee 클래스로 테스트")
    @CsvSource({"1, 2, 3, 3스트라이크", "4, 5, 6, 낫싱", "2, 1, 7, 2볼", "1, 3, 8, 1볼 1스트라이크"})
    void compare(int num1, int num2, int num3, String expected) {
        String gameResult = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(num1, num2, num3));
        assertThat(gameResult).isEqualTo(expected);
    }

}

package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundOutputDtoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,false", "0,0,true"})
    @DisplayName("스트라이크, 볼의 개수를 입력 받아 스트라이크, 볼, 낫싱 여부를 반환한다")
    void create(final int strike, final int ball, boolean expectedThreeOut) {
        RoundOutputDto roundOutputDto = RoundOutputDto.of(strike, ball);

        assertAll(
                () -> assertThat(roundOutputDto.strike()).isEqualTo(strike),
                () -> assertThat(roundOutputDto.ball()).isEqualTo(ball),
                () -> assertThat(roundOutputDto.isThreeOut()).isEqualTo(expectedThreeOut)
        );
    }
}

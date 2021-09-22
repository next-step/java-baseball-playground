package baseball.domain;

import baseball.dto.RoundOutputDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RoundTest {

    @Test
    @DisplayName("스트라이크, 볼, 쓰리아웃 여부를 반환한다")
    void countResult() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Balls balls = Balls.from(numbers);
        Round round = Round.from(balls);
        List<Integer> userNumbers = Arrays.asList(2, 1, 3);
        Balls userBalls = Balls.from(userNumbers);

        RoundOutputDto roundOutputDto = round.countResult(userBalls);

        assertAll(
                () -> assertThat(roundOutputDto.strike()).isEqualTo(1),
                () -> assertThat(roundOutputDto.ball()).isEqualTo(2)
        );
    }

    @ParameterizedTest
    @MethodSource("ballParameterProvider")
    @DisplayName("라운드의 종료 여부를 반환한다")
    void isOver(List<Integer> numbers, boolean expect) {
        Balls balls = Balls.from(numbers);
        Round round = Round.from(balls);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3);
        Balls userBalls = Balls.from(userNumbers);
        RoundOutputDto roundOutputDto = round.countResult(userBalls);

        boolean actual = round.hasEnough(roundOutputDto.strike());

        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> ballParameterProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3), true),
                arguments(Arrays.asList(7, 8, 9), false)
        );
    }
}

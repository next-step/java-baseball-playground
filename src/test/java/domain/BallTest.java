package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallTest {

    @ParameterizedTest
    @MethodSource("compareTestArgument")
    @DisplayName("숫자 야구를 비교해서 상태를 반환한다")
    void compare(Ball ball, Ball other, BallStatus expected) {

        BallStatus actual = ball.compare(other);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> compareTestArgument() {
        return Stream.of(
                arguments(Ball.of(1, 1), Ball.of(2, 2), BallStatus.NOTHING),
                arguments(Ball.of(1, 1), Ball.of(1, 2), BallStatus.BALL),
                arguments(Ball.of(1, 1), Ball.of(1, 1), BallStatus.STRIKE)
        );
    }
}

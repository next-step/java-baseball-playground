package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BallStatusesTest {

    private BallStatuses ballStatuses;

    @BeforeEach
    void setUp() {
        List<BallStatus> statuses = List.of(BallStatus.STRIKE, BallStatus.BALL, BallStatus.NOTHING);
        ballStatuses = BallStatuses.from(statuses);
    }

    @Test
    @DisplayName("스트라이크의 개수를 반환한다")
    void countStrike() {
        int expected = 1;

        int actual = ballStatuses.countStrike();

        assertThat(actual).isEqualTo(expected);
    }


    @Test
    @DisplayName("스트라이크의 개수를 반환한다")
    void countBall() {
        int expected = 1;

        int actual = ballStatuses.countBall();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("invalidBallStatusesArgument")
    @DisplayName("숫자야구공들의 길이가 3이 아니면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_ball_statuses_size(List<BallStatus> invalidStatuses) {
        assertThatIllegalArgumentException().isThrownBy(() -> BallStatuses.from(invalidStatuses))
                .withMessage("숫자야구 상태의 길이는 3이어야 합니다");
    }

    static Stream<Arguments> invalidBallStatusesArgument() {
        return Stream.of(
                arguments(List.of(BallStatus.STRIKE, BallStatus.BALL)),
                arguments(List.of(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.BALL, BallStatus.NOTHING))
        );
    }
}

package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallsTest {

    @Test
    @DisplayName("숫자 야구 공의 길이가 3이 아니라면 예외를 발생시킨다")
    void create_throws_exception_with_invalid_length() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 9);

        assertThatIllegalArgumentException().isThrownBy(() -> Balls.from(numbers))
                .withMessage("길이가 3이어야 합니다");
    }

    @Test
    @DisplayName("숫자 야구공의 숫자에 중복이 존재하면 예외를 발생시킨다")
    void create_throws_exception_with_duplicate_numbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        assertThatIllegalArgumentException().isThrownBy(() -> Balls.from(numbers))
                .withMessage("중복된 수가 존재합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,STRIKE", "1,2,BALL", "4,1,NOTHING"})
    @DisplayName("숫자 야구 공들을 입력받아 볼의 상태를 반환한다")
    void compareBallStatus(int number, int position, BallStatus expected) {
        Balls balls = Balls.from(Arrays.asList(1, 2, 3));
        Ball other = Ball.of(number, position);

        BallStatus actual = balls.compareBallStatus(other);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("숫자 야구 공들을 입력받아 볼의 상태들을 반환한다")
    void compare() {
        Balls balls = Balls.from(List.of(1, 2, 3));
        Balls others = Balls.from(List.of(1, 3, 7));

        BallStatuses actual = balls.compare(others);

        assertThat(actual).isNotNull();
    }
}

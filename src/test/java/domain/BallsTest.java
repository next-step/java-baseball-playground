package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}

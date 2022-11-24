package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumbersTest {

    @DisplayName("UserNumbers 크기가 3개가 아닐시 예외를 발생 시킵니다.")
    @Test
    void generateNumbers_Exception_Size() {
        assertThatThrownBy(() -> new UserNumbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("userNumbers 중복된 숫자가 있을 시 예외를 발생 시킵니다.")
    @Test
    void generateNumbers_Exception_Duplicate() {
        assertThatThrownBy(() -> new UserNumbers(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("userNumbers 범위에 맞지 않는 숫자가 있을 시 예외를 발생 시킵니다.")
    @Test
    void generateNumbers_Exception_OutofBoundary() {
        assertThatThrownBy(() -> new UserNumbers(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new UserNumbers(List.of(0, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
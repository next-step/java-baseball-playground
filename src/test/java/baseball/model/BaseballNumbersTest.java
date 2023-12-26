package baseball.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    // TODO: 12/19/23
    // 1. validateSize (O)
    // 2. validateDuplication (O)
    // 3. (1), (2) 파라미터라이즈 테스트 (O)

    @ParameterizedTest
    @MethodSource("validateSizeGenerateData")
    @DisplayName("중복 값이 있는지 확인 후 중복 값이 있으면 IllegalArgumentException 예외 발생")
    void validateSize(List<Integer> number) {
        List<Integer> numbers = new ArrayList<>(number);
        assertThatThrownBy(() -> new BaseballNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateSizeGenerateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 2)),
                Arguments.of(Arrays.asList(1, 2, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("validateDuplicationGenerateData")
    @DisplayName("3자리 숫자가 아니면 IllegalArgumentException 예외 발생")
    void validateDuplication(List<Integer> number) {
        List<Integer> numbers = new ArrayList<>(number);
        assertThatThrownBy(() -> new BaseballNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateDuplicationGenerateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3, 4))
        );
    }
}
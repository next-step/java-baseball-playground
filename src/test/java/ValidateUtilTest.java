import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateUtilTest {

    @ParameterizedTest
    @MethodSource("generateNumbers")
    void 자리수가_3자리_인지를_확인(String input, boolean result){
        assertThat(ValidateUtil.isLengthNot3(input)).isEqualTo(result);
    }

    static Stream<Arguments> generateNumbers() {
        return Stream.of(
            Arguments.of("123", false),
            Arguments.of("1", true),
            Arguments.of("", true),
            Arguments.of("1234", true)
        );
    }
}
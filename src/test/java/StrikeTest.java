import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class StrikeTest {

    private Strike strike = new Strike();
    private static final List<String> RANDOM = new ArrayList<>(Arrays.asList("1", "2", "3"));

    @ParameterizedTest
    @MethodSource("generateNumbers")
    void 스트라이크_갯수가_잘나오는지_확인(List<String> numbers,int strikeCount){

        Assertions.assertThat(strike.getStrike(RANDOM, numbers)).isEqualTo(strikeCount);
    }

    static Stream<Arguments> generateNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "3"), 3),
            Arguments.of(Arrays.asList("3", "4", "5"), 0),
            Arguments.of(Arrays.asList("1", "2", "4"), 2),
            Arguments.of(Arrays.asList("1", "5", "7"), 1)
        );
    }

}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BallTest {

    private Ball ball = new Ball();
    private static final List<String> RANDOM = new ArrayList<>(Arrays.asList("1", "2", "3"));

    @ParameterizedTest
    @MethodSource("generateData")
    void 볼_갯수가_잘나오는지_확인(List<String> numbers, int ballCount) {
        final int ballResult = ball.getBall(RANDOM, numbers);

        assertThat(ballResult).isEqualTo(ballCount);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(Arrays.asList("1", "2", "3"), 0),
            Arguments.of(Arrays.asList("3", "4", "5"), 1),
            Arguments.of(Arrays.asList("2", "1", "5"), 2),
            Arguments.of(Arrays.asList("3", "1", "2"), 3)
        );
    }
}
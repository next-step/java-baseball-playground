package training2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultJudgeTest {

    static Stream<Arguments> numData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 3), false),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5), false)
        );
    }

    @ParameterizedTest
    @DisplayName("숫자 비교 후 판단 로직")
    @MethodSource("numData")
    void resultJudge(List<Integer> computer, List<Integer> player, boolean expected) {
        ResultJudge re = new ResultJudge();
        assertThat(re.resultJudge(computer, player)).isEqualTo(expected);
    }
}
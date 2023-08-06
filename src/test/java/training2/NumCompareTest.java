package training2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumCompareTest {
    NumCompare numCompare = new NumCompare();

    static Stream<Arguments> numData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 3), 2),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5), 1)
        );
    }

    static Stream<Arguments> numData1() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 4), 2),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5), 1),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1), 3)
        );
    }

    @ParameterizedTest
    @DisplayName("스트라이크 확인")
    @MethodSource("numData")
    void countStrike(List<Integer> computer, List<Integer> player, int count) {
        assertThat(numCompare.countStrike(computer, player)).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("볼 확인")
    @MethodSource("numData1")
    void countBall(List<Integer> computer, List<Integer> player, int count) {
        assertThat(numCompare.countBall(computer, player)).isEqualTo(count);
    }
}
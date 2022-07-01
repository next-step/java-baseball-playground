package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("separateNumbers")
    @DisplayName("세자리 수의 범위는 1부터 9까지이다.")
    void 세자리_수는_1부터_9까지(int inputNumber) {
        assertTrue(inputNumber < 10);
    }

    @Test
    @DisplayName("세자리의 수는 서로 다르다.")
    void 서로_다른_수() {
        List<Integer> numbers = numberGenerator.createNumbers();
        int one = numbers.get(0);
        int two = numbers.get(1);
        int three = numbers.get(2);

        assertNotEquals(one, two);
        assertNotEquals(one, three);
        assertNotEquals(two, three);
    }

    @Test
    @DisplayName("컴퓨터는 3자리의 수를 생성한다.")
    void 세자리의_수_생성() {
        List<Integer> numbers = numberGenerator.createNumbers();
        assertEquals(3, numbers.size());
    }


    private static Stream<Integer> separateNumbers() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.createNumbers();
        return Stream.of(
                numbers.get(0),
                numbers.get(1),
                numbers.get(2)
        );
    }
}
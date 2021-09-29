package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest // 테스트 시 매개변수를 넣어준다.
    @ValueSource(ints = {1, 2, 3})
        // 넣어 줄 매게변수를 배열 형태로 지정한다.
    void numbers_isTrue(int i) { // 이 매개변수는 @ParameterizedTest 가 넣어 주는 것이다. @ValueSource 값들을
        assertThat(numbers.contains(i)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "TeSt,TEST", "jAva, JAVA"})
        // 왼쪽 값은 사용자 입력값, 오른쪽 값은 기댓값이다.
    void csbEx(String input, String expected) { // input 에는 왼쪽 값이, expected 에는 오른쪽 값이 들어온다.
        String inputExpected = input.toUpperCase(Locale.ROOT);
        assertThat(inputExpected).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    void numbers_true_false_test(String input, String bool) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(bool));
    }
}

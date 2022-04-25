package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
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
    void size() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains1(int number) throws Exception {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,4", "2,5", "3,6"})
    void contains2(int n1, int n2) throws Exception {
        assertThat(numbers.contains(n1)).isTrue();
        assertThat(numbers.contains(n2)).isFalse();
    }


}

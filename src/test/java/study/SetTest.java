package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
        //assertThat(numbers.size()).isEqualTo(4);
    }
    @DisplayName("true만 리턴")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setContainsTest_onlyTrue(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }
    @DisplayName("true, false 같이 리턴")
    @ParameterizedTest
    @CsvSource(value = {"1 : true", "2 : true", "3 : true", "4 : false", "5 : false"},
            delimiter = ':')
    public void setConstainsTest_trueOrFalse(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}

package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

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

    // Test Case 구현
    @DisplayName("set size test")
    @Test
    void setSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set contains method test")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int p_int){
        assertThat(numbers.contains(p_int)).isTrue();
    }

    @DisplayName("contains method test by different input")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter =  ':')
    void diffInput(int element, boolean expected){
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}

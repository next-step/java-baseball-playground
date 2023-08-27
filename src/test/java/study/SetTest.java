package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    private Set<Integer> anotherNumbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        anotherNumbers = new HashSet<>();
        anotherNumbers.add(4);
        anotherNumbers.add(5);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set.size() 매서드가 셋의 크기를 반환함을 테스트")
    void size(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void simpleContains(int setNumbers){
        assertThat(numbers).contains(setNumbers);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(int pass, boolean notPass){
        assertThat(numbers.contains(pass)).isEqualTo(notPass);
    }
}
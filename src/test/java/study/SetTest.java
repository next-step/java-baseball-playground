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

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //요구사항1
    @Test
    @DisplayName("Set의 size 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    //요구사항2
    @DisplayName("contains 메서드 사용과 중복 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    //요구사항3
    @ParameterizedTest
    @CsvSource(value = {"1:true" , "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithExceptionTest (int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}

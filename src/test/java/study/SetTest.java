package study;

import org.assertj.core.api.Assertions;
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

    // Test Case 구현
    //Set사이즈 구하는 테스트
    @Test
    public void size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void contains() { //가능은 하지만 너무 많은 중복 발생 JUnit의 ParameterizedTest활용
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("Set 내부 값의 존재 여부 확인 - 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void usingContains(int nums) {
        assertThat(numbers.contains(nums)).isTrue();
    }

    @DisplayName("Set 내부 값의 존재 여부 확인 - 중복코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3,4,5})
    void usingContains2(int nums) {
        assertThat(numbers.contains(nums)).isTrue();
    }

    @DisplayName("CsvSource를 활용")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @ParameterizedTest
    void usingContains_true_false (int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    // test case 구현
    @Test
    @DisplayName("set 중복을 허용하지 않는 자료구조")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @DisplayName("ParameterizedTest - 중복소거")
    @ValueSource(ints = {1, 2, 3})
    void contains1(Integer integer) {
        assertThat(numbers).contains(integer); //contains 메소드 결과 값이 true인 경우만 테스트 가능
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest - 입력 값에 따라 결과 값이 다른 경우")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains2(String input, String output) {
        boolean actualNum = numbers.contains(Integer.parseInt(input));
        assertEquals(Boolean.parseBoolean(output),actualNum);
    }
}

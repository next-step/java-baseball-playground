package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.DisplayName;


public class SetTest {
    private Set<Integer> numbers;
    @BeforeEach
    @Test
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        // Test Case 구현
        // 요구사항 1번. Set의 size() 메소드를 활용해 Set의 크기를 확인
        assertThat(numbers.size()).isEqualTo(3);

        // 요구사항 2번.
    }
//    @Test
//    void contains() {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
//    }
    // 요구사항 2번 -> test code-refactoring
//    @ParameterizedTest
//    @ValueSource(ints = {1, 2, 3})
//    void ParameterizedTest(int input) {
//        assertTrue(numbers.contains(input));
//    }

    // 요구사항 3번. 1,2,3이 True인 경우만 test를 진행했다. 그 외에 경우를 boolean의 값으로 반환하는 테스트 코드 작성
    @DisplayName("True가 아닌 인자값도 검사 하는 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void ParmasTestCode(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}


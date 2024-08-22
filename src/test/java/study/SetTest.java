package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 사이즈 확인 테스트")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set안에 매개변수가 존재하는지 확인")
    void contains1(int arr) { //매번 배열에서 하나의 인수를 메스드 매개변수에 할당한다.
        //중복코드 생성 안하고 구현
        assertTrue(numbers.contains(arr));
    }

    //1,2,3값 -> true
    //4,5 값 -> false
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("1,2,3인 경우 true / 4,5인 경우 false 반환 테스트")
    void contains2(int input , boolean bool) {
        assertThat(numbers.contains(input)).isEqualTo(bool);
    }
}

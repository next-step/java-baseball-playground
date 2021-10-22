package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {

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
    @DisplayName("size() 메서드")
    void test1() {
        int result = numbers.size();

        System.out.println("result: " + result);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("contains() 메서드")
    void test2() {

        // numbers contains() 메서드를 활용해 값 확인
        // 중복코드 발생 -> JUnit의 ParameterizedTest
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    /**
     * ParameterizedTest는 ValueSource annotation 에 지정한 배열을 파라미터 값으로 순서대로 넘겨준다.
     * 참고: https://gmlwjd9405.github.io/2019/11/27/junit5-guide-parameterized-test.html
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest 사용 예제")
    void test2(int num) {

        System.out.println("result: " + num);
        assertThat(numbers.contains(num)).isTrue();

    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("CsvSource 활용")
    void test3(int num, boolean expected) {
        System.out.println("num: " + num + ", expected: " + expected);
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }


}


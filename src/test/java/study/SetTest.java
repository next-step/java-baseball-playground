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

/**
 * Set Collection에 대한 학습 테스트
 */
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

    @Test
    @DisplayName("요구사항 1 : Set의 size() 메서드를 활용 크기 확인하기")
    void set_size(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("요구사항 2 : Set의 contains() 메서드를 활용하여 1,2,3 포함여부 확인한다. ParameterizedTest 이용하여")
    void parameterizedTest(int idx){

        /*
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        */

        //ParameterizedTest 를 이용하여 위 코드를 간략하게 표현해보자.
        assertThat(numbers.contains(idx)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @DisplayName("요구사항 3 : 요구사항2는 true 만 가능하다. false,true 모두 확인하자")
    void parameterizedTest_csvSource(int idx,boolean delimiter){
        assertThat(numbers.contains(idx)).isEqualTo(delimiter);
    }
}

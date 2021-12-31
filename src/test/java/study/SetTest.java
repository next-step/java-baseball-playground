package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;


import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Test Case 구현")
    @Test
    void setTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("반복되는 테스트 구현")
    //ParameterizedTest: 반복되는 테스트를 구현하기 위해 사용되는 Annotation 이다
    //혼자 사용할 수 없고, 반복되는 테스트들의 인자들을 넣기 위해 ValueSource 혹은 CsvSource 를 사용하여야 한다
    @ParameterizedTest
    //ValueSource 한가지의 자료형을 테스트 인자로 넣을 수 있다
    @ValueSource(ints = {1, 2, 3})
    void numbersTest(int list){
        assertThat(numbers.contains(list)).isTrue();
    }

    @DisplayName("true 값 뿐만아니라 false값도 테스트 하기")
    @ParameterizedTest
    //CsvSource: Csv 파일, 해쉬태이블과 같이 1대1로 값을 대응시켜 저장할 수 있다
    //또한 ValueSource와 다르게 두가지 이상의 자료형을 테스트 인자로 넣어 사용할 수 있다
    @CsvSource(value = {"1:true","2:true","3:true", "4:false", "5:false"}, delimiter = ':')
    void numbersFalseTest(int input, boolean expected){
        //assertThat 내용이 isEqualTo의 내용과 같은가? -> 같다면 테스트 성공 아니면 실패
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}

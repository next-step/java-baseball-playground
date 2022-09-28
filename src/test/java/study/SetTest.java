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
    @Test
    @DisplayName("Set의 크기 확인")
    void CheckSizeOfSet(){
        assertThat(numbers).size().isEqualTo(3);
    }
    @Test
    @DisplayName("Set의 1,2,3 값 존재 여부 확인_첫번째 풀이")
    void isContains_CheckIfAValueExists_FirstExplanation(){
        for(int index = 1; index<=3; index++)
            assertThat(numbers.contains(index)).isTrue();
    }
    @Test
    @DisplayName("Set의 1,2,3 값 존재 여부 확인_두번째 풀이")
    void isContains_CheckIfAValueExists_SecondExplanation(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @DisplayName("assertThat 코드 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void isContains_RemoveDuplicateAssertThatCode(int index){
        assertThat(numbers.contains(index)).isTrue();
    }
    @DisplayName("입력값과 기댓값 비교_입력값과 기댓값 구분 연산자로 ',(comma)'사용")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void toCompare_InputValueToExpectedValue_UsingComma(int input, boolean expected){
        assertEquals(expected,numbers.contains(input));
    }
    @DisplayName("입력값과 기댓값 비교_입력값과 기댓값 구분 연산자로 ':(colon)'사용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter=':')
    void toCompare_InputValueToExpectedValue_UsingColon(int input, boolean expected){
        assertEquals(expected,numbers.contains(input));
    }
}
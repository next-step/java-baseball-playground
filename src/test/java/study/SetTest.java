package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/*
지원을 안해준다.hamcrest
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
*/

/*
파악 필요
import static org.hamcrest.MatcherAssert.assertThat;*/


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class SetTest {
    private Set<Integer> numbers;
    // Set은 무엇이며 HashSet은 어떤구조로 이루어져있는가?

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("현재 Set에 담긴 데이터 값이 4개인지")
    void sizeFour() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("현재 Set에 담긴 데이터 값이 3개인지")
    void sizeThree() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("값들이 정상적으로 존재하는지 확인")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    // 중복되는 코드들은 생각해서 개발 필요
    // 둘다 동일한건지 확인 필요 import static org.hamcrest.MatcherAssert.assertThat;
    @ParameterizedTest
    @ValueSource(strings = {"", ""})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThat(input).isEqualTo("");
    }

    // 입력값에 따른 결과값이 달라지는 테스트 구현
    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test","Java:java","asb:sss"}, delimiter = ':')
    void toLowerCase_shouldGenerateTheExpectedLowercaseValue(String input,String expected) {
        String actualValue = input.toLowerCase();
        assertThat(expected).isEqualTo(actualValue);
    }

}

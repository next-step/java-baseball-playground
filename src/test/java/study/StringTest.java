package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

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
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항_1() {

        String[] split = "1,2".split(",");

        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void 요구사항_2() {

        String str = "(1,2)";
        int start = str.indexOf("(");
        int end = str.indexOf(")");

        String substring = str.substring(start + 1, end);
        System.out.println(substring);
    }

    @Test
    @DisplayName("이거 문제가 이상한데요?")
    void 요구사항_3() {

        String str = "abc";

        assertThatThrownBy(() -> {
            char c = str.charAt(str.length());
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    /**************************************************************************************************************
     * Set Collection
     * *************************************************************************************************************/
    @Test
    void 콜렉션_요구사항_1() {
        assertEquals(3, numbers.size());
    }

    @Test
    void 콜렉션_요구사항_2() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 콜렉션_요구사항_2_parameterizedTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
        assertThat(numbers.contains(input)).isTrue();
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 콜렉션_요구사항_3(Integer input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}

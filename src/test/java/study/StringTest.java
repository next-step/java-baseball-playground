package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    /* 요구사항 1)
    -"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다. (O)
    -"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다. (O)
    [힌트]
    -배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    -배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
    */
    @Test
    @DisplayName("배열 요소에 1,2 모두 포함한다.")
    void split() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).containsAll(Arrays.asList("1", "2"));
        assertThat(numbers).containsExactly("1", "2");
    }

    @Test
    @DisplayName("배열에 1만 존재한다.")
    void split1() {
        String[] number = "1".split(",");
        assertThat(number).containsAll(Arrays.asList("1"));
        assertThat(number).containsExactly("1");
    }

    /* 요구사항 2)
    -"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    */
    @Test
    @DisplayName("괄호를 제거하고 숫자만 반환한다.")
    void substring() {
        String number = "(1,2)".substring(1,4);
        assertThat(number).isEqualTo("1,2");
    }

    /* 요구사항 3)
    -"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    -String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    */
    @Test
    @DisplayName("b를 가져온다.")
    void charAtB() {
        String b = String.valueOf("abc".charAt(1));
        assertThat(b).isEqualTo("b");
    }

    @Test
    @DisplayName("charAt 범위를 넘어서서 특정 문자를 가져오지 못한다.")
    void charAtException2() {
        String string = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    string.charAt(2);
                    throw new StringIndexOutOfBoundsException("Index 2 out of bounds for length 3");
                });

    }
}

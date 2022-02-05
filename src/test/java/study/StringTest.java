package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1_1() {
        String[] strings = "1,2".split(",");
        assertThat(strings).contains("1", "2");
    }

    @Test
    void test1_2() {
        String[] strings = "1".split(",");
        assertThat(strings).containsExactly("1");
    }

    @Test
    void test2() {
        String strings = "(1,2)";
        String substring = strings.substring(1, strings.length()-1);
        System.out.println(substring);
    }


    @Test
    @DisplayName("요구사항 3 테스트 구현")
    void test3() {
        String strings = "abc";
        int index = 10;
        assertThatThrownBy(() -> {
            strings.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", index);
    }
}

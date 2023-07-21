package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void first() {
        String[] firstTest = "1".split(",");
        assertThat(firstTest).contains("1");
        String[] secondTest = "1,2".split(",");
        assertThat(secondTest).containsExactly("1","2");
    }
    @Test
    void second() {
        String firstTest = "(1,2)".replace("(","").replace(")","");
        assertThat(firstTest).isEqualTo("1,2");
    }
    @Test
    @DisplayName("String 에서 charAt을 이용하여 특정 위치의 문자열을 가져오고 예외처리를 한다.")
    void third(){
        String str = "abc";
        str.charAt(0);
        str.charAt(1);
        str.charAt(2);

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(3);
        }).withMessageMatching("Index : \\d+, Size : \\d+");
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

    }




}

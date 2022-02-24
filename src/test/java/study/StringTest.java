package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
        //assertThat(actual).isEmpty();
    }
    @Test
    public void split() {
        String[] values = "1,2".split(",");
        assertThat(values).contains("1");
        assertThat(values).contains("2");
        assertThat(values).contains("1", "2");
        assertThat(values).contains("2", "1");
        //assertThat(values).containsExactly("1");//false
        //assertThat(values).containsExactly("2");//false
        //assertThat(values).containsExactly("2", "1");//false
        assertThat(values).containsExactly("1", "2");
        values = "1".split(",");
        assertThat(values).contains("1");
        assertThat(values).containsExactly("1");
    }
    @Test
    public void substring() {
        String value = "(1,2)".substring(1, 4);
        assertThat(value).contains("1");
        assertThat(value).contains("1", ",");
        assertThat(value).contains("1", ",", "2");
        assertThat(value).contains(",", "2");
        assertThat(value).contains("2");
        assertThat(value).contains("1", "2");
        assertThat(value).contains(",");
    }
    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    public void charAt() {
        String value = "abc";
        /*
        assertThatThrownBy(() -> {
            value.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("Index: 2, Size: 3");
         */

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    value.charAt(3);
                }).withMessageMatching("Index: 2, Size: 3");
    }
}

package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        //containsExactly : 해당 원소들의 순서, 값 모두 맞는 지 확인 하는 메서드.
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
        String[] val = "1".split(",");
        assertThat(val).containsExactly("1");
    }

    @Test
    void substring() {
        String val = "(1,2)".substring(1, 4);
        assertThat(val).isEqualTo("1,2");
    }

    /**
     * hasNoCause() : thrown 여부 확인
     * withMessageContaining : 에러 메세지에 특정 문자열이 포함되는지 확인
     */
    @Test
    @DisplayName("Get specific location of string test")
    void charAt() {
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        //assertThatThrownBy
        assertThatThrownBy(() -> {
            actual.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

        //assertThatExceptionOfType
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {actual.charAt(3);})
                .withMessage("String index out of range: %s", "3")
                .withMessageContaining("index out of")
                .withNoCause();

        //doesNotThrowAnyException
        assertThatCode(() -> {
            actual.charAt(2);
        }).doesNotThrowAnyException();

        //assertThatIOException
//        assertThatIOException().isThrownBy(() -> { throw new IOException("boom!"); })
//                .withMessage("%s!", "boom")
//                .withMessageContaining("boom")
//                .withNoCause();
    }

}


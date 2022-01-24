package study;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split(){
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
        System.out.println(Arrays.toString(actual));

        String[] actual1 = "1,2".split(",");
        assertThat(actual1).contains("1","2");
        assertThat(actual1).containsExactly("1","2");
        System.out.println(Arrays.toString(actual1));
    }
    @Test
    void substring(){
        String actual = "(1,2)";
        actual = actual.substring(1);
        actual = actual.substring(0,3);
        System.out.println(actual);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        assertThatThrownBy(() -> {
            String actual = "abc";
            System.out.println(actual.charAt(2));

            throw new IndexOutOfBoundsException("boom!");

        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("인덱스 범위를 초과했습니다.");

    }

}

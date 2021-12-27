package step1.test0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("split test")
    @Test
    void test1(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

        String[] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @DisplayName("substring test")
    @Test
    void test2(){
        String result = "(1,2)";
        String newResult = result.substring(1, 4);
        assertThat(newResult).isEqualTo("1,2");
        System.out.println(newResult);
    }

    @DisplayName("chatAt / StringIndexOutOfBoundsException test")
    @Test
    void test3(){
        String result = "abc";
        System.out.println(result);

        assertThatThrownBy(() ->{
            result.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index : 3, Size : 3");
    }

}

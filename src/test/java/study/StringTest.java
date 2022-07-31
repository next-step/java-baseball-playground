package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @Test
    void replace(){
        String actual = "abc".replace("b","d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String[] actual12 = "1,2".split(",");
        String[] actual1 = "1".split(",");
        //System.out.println(Arrays.toString(actual1));
        assertThat(actual12).contains("1","3");
        assertThat(actual1).containsExactly("1");
    }

    @Test
    void substring(){
        String substring = "(1,2)".substring("(1,2)".indexOf("1"),"(1,2)".indexOf(")"));
        System.out.println(substring);
    }

    @Test
    @DisplayName("charAt()이 특정 문자의 위치를 정확히 가져오는지 확인하는 코드")
    public void exception(){
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()-> {
                    char val = actual.charAt(3);
                    throw new Exception("범위초과");

                }).withMessageContaining("");
    }

}

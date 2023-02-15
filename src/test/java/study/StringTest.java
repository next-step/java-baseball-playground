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
    void split(){
        String numberArrayString = "1,2";
        String[] numbers = numberArrayString.split(",");
        assertThat(numbers).containsExactly("1","2");
    }

    @Test
    void split2(){
        String numberArrayString = "1";
        String[] numbers = numberArrayString.split(",");
        assertThat(numbers).contains("1");
    }

    @Test
    void substring(){
        String actual = "(1,2)";
        int openIndex = actual.indexOf("(");
        if (openIndex > -1){
            actual = actual.substring(openIndex+1);
        }
        int closeIndex = actual.indexOf(")");
        if (closeIndex > -1){
            actual = actual.substring(0, closeIndex);
        }
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void charAt(){
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열길이보다 큰 인덱스 입력시 오류발생")
    void throwException(){
        assertThatThrownBy(()->"abc".charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

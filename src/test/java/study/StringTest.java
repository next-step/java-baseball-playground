package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split(){
        String number = "1,2";
        String[] split = number.split(",");
        assertThat(split).contains("1","2");
        assertThat(split).containsExactly("1","2");
    }

    @Test
    void substring(){
        String number ="(1,2)";
        String substring = number.substring(1, 4);
        assertThat(substring).contains("1,2");
    }

    @DisplayName("exception 발생 테스트")
    @Test
    void charAt() {
        String alphabet = "abc";
        /*
        assertThatThrownBy(()->{
            alphabet.charAt(6);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("index 최대 2 , size : "+alphabet.length());
    }
         */
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->{
                    alphabet.charAt(10);
                }).withMessage("index :"+alphabet.length());
    }


}

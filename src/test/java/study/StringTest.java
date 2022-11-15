package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2를 ,로 split 했을 때 [1,2]로 나오는 지 확인")
    void test1(){
        final String sentence = "1,2";
        final String[] split = sentence.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만 포함하는 배열인지 확인")
    void test2(){
        String one = "1";
        final String[] split = one.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("subString Test")
    void test3(){
        final String s = "(1,2)";
        final String substring = s.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void test4(){
        final String abc = "abc";
        assertThatThrownBy(() -> abc.charAt(5))
            .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void test5(){
        final Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);

        assertThat(number.size()).isEqualTo(3);
    }

    @Test
    void test6(){
        final Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);

        assertThat(number.contains(1)).isTrue();
        assertThat(number.contains(2)).isTrue();
        assertThat(number.contains(3)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","4:false"},delimiter = ':')
    void test7(String input, String expected){
        final Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
        number.add(3);

        Integer newInput = Integer.valueOf(input);
        Boolean expect = Boolean.valueOf(expected);

        assertThat(number.contains(newInput)).isEqualTo(expect);
    }

}

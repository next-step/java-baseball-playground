package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    //given : 주어진 상황
    //when : 이것을 실행했을 때
    //then : 이런 결과가 나와야 한다


/**
 * String 클래스에 대한 학습 테스트
 * */

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    //요구사항 1
    @Test
    void split(){
        //given
        String answer = "1,2";
        //when
        String []answerArr = answer.split(",");
        //then
        assertThat(answerArr).containsExactly("1","2");

    }

    //요구사항 2
    @Test
    void substring(){
        //given
        String answer = "(1,2)";
        //when
        answer.substring(1,3);
        //then
        assertThat(answer).isEqualTo("(1,2)");
    }


    //요구사항 3
    @Test
    void charAt(){
        //given
        String answer = "abc";

        //when
        assertThatThrownBy(() ->
            answer.charAt(answer.length()))
        .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("범위밖을 벗어남");
    }



}

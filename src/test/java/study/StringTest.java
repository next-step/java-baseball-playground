package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * String 에 대한 학습테스트
 */
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1 : split 활용하여 분리 후 contains 로 정상 분리되었는지 확인")
    void split_contains() {
        String actual = "1,2";
        assertThat(actual.split(",")).contains("1","2");
    }

    @Test
    @DisplayName("요구사항 1 : split 활용하여 분리 후 containsExactly 로 정상 분리되었는지 확인")
    void split_containExactly() {
        String actual = "1";

        assertThat(actual.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : subString활용하여 특정문자를 제거하고 체크해보자")
    void substring(){
        String actual = "(1,2)";

        assertThat(actual.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : chatAt()메서드 활용하며 charAt 인덱스가 벗어났을때 오류 확인")
    void chatAt(){
        String actual = "abc";

        assertThatThrownBy(()->{
           actual.charAt(actual.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 with")
    public void charGetFromString2() {
        String actual = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(actual.length());
                }).withMessageContaining("%d", actual.length());
    }



}

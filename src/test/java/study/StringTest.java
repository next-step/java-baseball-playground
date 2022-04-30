package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("replace에 대한 처리")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split에 대한 처리")
    void split(){
        String[] result = "1,2".split(",");
       /* assertThat("1").isEqualTo(result[0]);
        assertThat("2").isEqualTo(result[1]);*/
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("subString에 대한 처리")
    void substring(){
        //substring은 시작과 끝을 지정하면 사이 인덱스에 존재하는 char을 제외하고 모두 날린다.
        String expect = "(1,2)".substring(1,"(1,2)".length() - 1);
        assertThat(expect).contains("1,2");
    }

    @Test
    @DisplayName("범위가 넘었을 때에 대한 처리 - exception")
    void exceptCharAt(){
        //char choice = "abc".charAt("abc".indexOf("b") + 5);
        //assertThat("b").contains("b");
        Assertions.assertThrows(StringIndexOutOfBoundsException.class,
                () -> "abc".charAt("abc".indexOf("b") + 5));
    }
}

package study;

import org.junit.jupiter.api.Disabled;
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
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("2"); // contains는 asserThat의 변수 값이 들어만 있으면 성공 (순서, 부분 없음 상관 x)

        // 실패 사례
        //assertThat(result).containsExactly("2", "1"); // containsExactly 는 assertThat의 변수 값의 순서, 데이터 모두 일치하여하 true반환

        // 성공 사례
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("IndexOutOfBoundException 예외처리")
    void charAt() {
        char result = "abc".charAt(3);
        assertThatThrownBy(() -> {throw new IndexOutOfBoundsException("범위 밖 데이터 호출");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("범위 밖 데이터 호출");
    }
}

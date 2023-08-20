package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1", "2");
        //1.contains
        //중복여부, 순서에 관계 없이 값만 일치하면 테스트가 성공
        //String, Array, Set, List 모두 사용 가능
        //2.containsOnly
        //순서, 중복을 무시하는 대신 값 & 갯수가 정확히 일치
        //3.containsExactly
        //순서를 포함해서 정확히 일치
    }

    @Test
    void split2() {
        String[] split = "1".split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substring() {
        String substring = "(1,2)".substring(1, 4); //이상,미만
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException Test1")
    void charAt1() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    "abc".charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException Test2")
    void charAt2() {
        assertThatThrownBy(() -> {
            "abc".charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}

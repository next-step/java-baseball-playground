package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("알파벳_b를_d로_대체하기(replace)")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*
    * ====================================================================
    * 요구사항 1
    * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    *
    * 힌트
    * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
    */
    @Test
    @DisplayName("','기준으로_문자열_구분(split)")
    void split() {
        String num = "1,2";
        String[] splitNums = num.split(",");
        assertThat(splitNums).contains("1", "2");
        assertThat(splitNums).containsExactly("1", "2");
    }

    /*
    * ====================================================================
    * 요구사항 2
    * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    * ====================================================================
    */
    @Test
    @DisplayName("괄호_제거하기(substring)")
    void subString() {
        String num = "(1,2)";
        num = num.substring(1, 4);
        assertThat(num).isEqualTo("1,2");
    }
    /*
    * ====================================================================
    * 요구사항 3
    * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    * ====================================================================
    */
    @Test
    @DisplayName("특정_위치의_문자_가져오기(charAt)")
    void charAt() {
        String str = "abc";
        int idx = 3;
        assertThatThrownBy(()->{
            str.charAt(idx);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d", idx);
    }
}

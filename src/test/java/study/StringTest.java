package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2를 분리테스트")
    void split1() {
        String[] arr = "1,2".split(",");
        assertThat(arr.length).isEqualTo(2);
    }

    @Test
    @DisplayName("','로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split2() {
        String[] arr = "1".split(",");
        assertThat(arr).containsExactly("1"); //containsExactly() : 순서를 포함해서 정확히 일치하는지 확인하는것 (중복,순서)
    }

    @Test
    @DisplayName("String의 substring() 메소드를 활용해 ()을 제거하고 문자열 반환 테스트")
    void substring() {
        //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String str = "(1,2)".substring(1,4); //startIndex 부터 endIndex 전까지 반환
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정위치의 인덱스 오류가 났을때")
    void split() {
        //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        String str = "abc";
        int index = 5;

        //assertThatThrownBy는 에러가 발생해야하는 상황을 테스트
        assertThatThrownBy(() -> {
            str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class) //isInstanceOf() : 해당 타입의 인스턴스인지를 비교하는 메서드
                .hasMessage("%d", index);
    }
}

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
        //  요구사항 1
        //  "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        //  "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
        String[] actual2 = "1,".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    void substring(){
        //  요구사항 2
        //  "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String str = "(1,2)";
        String actual = str.substring(0);
        actual.substring(str.length()-1);
        assertThat(actual).contains("1,2");
    }

    @Test
    @DisplayName("String를 index값으로 접근하여 character를 추출하기 위한 method")
    void chatAt(){
        //  요구사항 3
        //  "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        //  String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        //  JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }


}


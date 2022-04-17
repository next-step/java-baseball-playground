package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다. " +
            "'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitTest() {
        String givenString = "1,2";
        String givenString2 = "1";

        String[] splittedString = givenString.split(",");
        String[] splittedString2 = givenString2.split(",");

        assertThat(splittedString).containsExactly("1", "2");
        assertThat(splittedString2).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하도록 구현한다.")
    void splitTest2() {
        String givenString = "(1,2)";

        String updatedString = givenString.substring(givenString.indexOf('(') + 1, givenString.lastIndexOf(')'));

        assertThat(updatedString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void splitTest3() {
        String givenString = "abc";

        char firstChar = givenString.charAt(0);
        char secondChar = givenString.charAt(1);
        char thirdChar = givenString.charAt(2);

        assertThat(firstChar).isEqualTo('a');
        assertThat(secondChar).isEqualTo('b');
        assertThat(thirdChar).isEqualTo('c');
        assertThatThrownBy(() -> givenString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}

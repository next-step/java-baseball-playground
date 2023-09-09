package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    @DisplayName("문자열을 split 했을 때 잘 분리되는지 확인")
    void split(){
        // Given
        String str1 = "1,2";
        String str2 = "1";

        // When
        String[] actual = str1.split(",");
        String[] actual1 = str2.split(",");

        // Then
        assertThat(actual).containsExactly("1","2");
        assertThat(actual1).containsExactly("1");
    }

    @Test
    @DisplayName("문자의 괄호가 잘 지워지는지 확인")
    void substring(){
        // Given
        String input = "(1,2)";

        // When
        String actual = input.substring(1,input.length()-1);

        // Then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 잘 가져오는지 확인")
    void charAt(){
        // Given
        String input = "abc";

        // When
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);

        // Then
        assertThat(new char[]{first,second,third})
                .containsExactly('a','b','c');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,3})
    @DisplayName("위치값을 벗어났을 때의 예외를 테스트")
    void charAtException(int input) {
        // Given
        String str = "abc";

        assertThatThrownBy(() -> {
            char c = str.charAt(input);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: %d",input);
    }
}

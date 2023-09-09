package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}

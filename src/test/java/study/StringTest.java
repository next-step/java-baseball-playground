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
}

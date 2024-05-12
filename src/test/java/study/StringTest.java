package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.withPrecision;

import org.assertj.core.data.Offset;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
        // assertThat(actual).isEqualTo("test");
    }
    @Test
    public void splitTest(){
        String input = "1,2";
        String splitResult[] = input.split(",");
        assertThat(splitResult).contains("1");
        assertThat(splitResult).containsExactly("1", "2");
    }

    @Test
    public void substringTest(){
        String input = "(1,2)";
        String result = input.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
    
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    @Test
    public void charAtTest(){
        int index = 4;
        String input = "abc";
        
        assertThatThrownBy(() -> {
            char str = input.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 4");
    }

    @Test
    void test(){
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }


}


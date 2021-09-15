package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    void split() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1", "2");        
    }
    
    @Test
    void split2() {
        String[] nums = "1".split(",");
//        for(String num: nums) {
//            System.out.println(num);
//        }
        assertThat(nums).containsExactly("1");
    }
    
    @Test
    void substring() {
        String numbers = "(1,2)".substring(1,4);
        assertThat(numbers).isEqualTo("1,2");
    }
    
    @Test
    void chartAt() {
        char str = "abc".charAt(0);
        assertThat(str).isEqualTo('a');
    }
    
    @Test
    @DisplayName("특정 위치의 문자를 가져올때 위치값이 벗어난 경우")
    void chartAtException() {
        String str = "abc";
        int index = 5;
        assertThatThrownBy(()-> str.charAt(index))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining(String.format("String index out of range: %d", index));
    }
}

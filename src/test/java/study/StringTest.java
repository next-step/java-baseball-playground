package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        for(String num: nums) {
            System.out.println(num);
        }
        assertThat(nums).containsExactly("1");
    }
}

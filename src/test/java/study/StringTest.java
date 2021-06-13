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
    void subString() {
    	String test = "(1,2)";
    	test = test.substring(1,test.length()-1);
    	assertThat(test).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("charAt")
    void charAt() {
    	String test = "abc";
    	assertThatThrownBy(()->{
    		test.charAt(3);
    	}).isInstanceOf(IndexOutOfBoundsException.class)
    	.hasMessageContaining("Index:2, Size: 2");
    }
}

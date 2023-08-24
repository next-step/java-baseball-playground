package study;

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
    void split() {
    	String[] actual = "1,2".split(",");
    	assertThat(actual).containsExactly("1","2");
    	assertThat(actual).contains("1");
    }
    
    @Test
    void  substring() {
    	String actual = "(1,2)".substring(1,4);
    	assertThat(actual).isEqualTo("1,2");
    }
    
    @Test
    void charAt() {
    	//ver.1
    	assertThatThrownBy(() -> {
    		char actual = "abc".charAt(4);
    	}).isInstanceOf(IndexOutOfBoundsException.class)
    	  .hasMessageContaining("String index out of range");
    	
    	//ver.2
    }
    
    
}

package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
	@Test
    void split() {
    	String[] actual = "1,2".split(",");
		assertThat(actual).contains("1","2");
    	assertThat(actual).containsExactly("1","2");
    }
	
	@Test
	void substring() {
		String actual = "(1,2)".substring(1, 4);
		assertThat(actual).isEqualTo("1,2");
	}
	
	
	@Test
	@DisplayName("예외 체크")
	void testException() {
		assertThatThrownBy(() -> { throw new StringIndexOutOfBoundsException(String.valueOf("abc".charAt(3))); })
								.isInstanceOf(StringIndexOutOfBoundsException.class)
								.hasMessage("String index out of range: 3");
	}
}

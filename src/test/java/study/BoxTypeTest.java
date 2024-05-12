package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.junit.jupiter.api.Test;

public class BoxTypeTest {

    @Test
    void integerTest(){
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }

    
    
}
package study;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void calculator(){
        StringCalculator s = new StringCalculator();
        String[] strings = s.split("2 + 3 * 4 / 2");
        int actual = s.calculate(strings);
        assertThat(actual).isEqualTo(10);
    }

}

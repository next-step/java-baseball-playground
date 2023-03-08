package study;

import baseball.ComputerNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerNumbersTest {
    @Test
    void createComputerNumbers(){
        ComputerNumbers numbers = new ComputerNumbers(3);
        assertThat(numbers.isSize(3)).isTrue();

        ComputerNumbers numbers2 = new ComputerNumbers(2);
        assertThat(numbers2.isSize(1)).isFalse();
    }
}

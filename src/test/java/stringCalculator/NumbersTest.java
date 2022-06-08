package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumbersTest {

    Numbers number;

    @BeforeEach
    void setUp() {
        String input = "1 + 4 - 2 * 4 / 2";
        number = new Numbers(input.split(" "));
    }

    @Test
    void poll() {
        Integer poll = number.poll();
        assertThat(poll).isEqualTo(4);
        poll = number.poll();
        assertThat(poll).isEqualTo(2);
        poll = number.poll();
        assertThat(poll).isEqualTo(4);
        poll = number.poll();
        assertThat(poll).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        number.poll();
        assertThat(number.isEmpty()).isFalse();
        number.poll();
        assertThat(number.isEmpty()).isFalse();
        number.poll();
        assertThat(number.isEmpty()).isFalse();
        number.poll();
        assertThat(number.isEmpty()).isTrue();
    }
}

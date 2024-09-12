package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("abc", "betterplace");
        assertThat(actual).isEqualTo("betterplace");
    }
}

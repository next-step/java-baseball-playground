package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringTest {

    @Test
    public void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void split_test1() {
        String[] actual = "1,2".split(",");

        assertNotNull(actual);
        assertEquals(2, actual.length);

        assertEquals("1", actual[0]);
        assertEquals("2", actual[1]);
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void split_test2() {
        String[] actual = "1".split(",");

        assertNotNull(actual);
        assertEquals(1, actual.length);
        assertEquals("1", actual[0]);

    }
}

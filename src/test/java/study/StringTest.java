package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(actual).contains("1");
        assertThat(actual).contains("2");

        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void split_test2() {
        String[] actual = "1".split(",");

        assertThat(actual).containsOnly("1");
    }
}

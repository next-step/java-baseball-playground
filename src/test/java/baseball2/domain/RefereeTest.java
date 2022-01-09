package baseball2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private static final List<Integer> ANSWER = Arrays.asList(1,2,3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(ANSWER, Arrays.asList(1, 2, 3));
        assertThat(result).isEqualTo("0 볼 3 스트라이크");
    }

    @Test
    void 아웃() {
        String result = referee.compare(ANSWER, Arrays.asList(4, 5, 6));
        assertThat(result).isEqualTo("아웃");
    }

    @Test
    void 볼_3() {
        String result = referee.compare(ANSWER, Arrays.asList(3, 1, 2));
        assertThat(result).isEqualTo("3 볼 0 스트라이크");
    }

    @Test
    void 볼_2_스트라이크_1() {
        String result = referee.compare(ANSWER, Arrays.asList(2, 1, 3));
        assertThat(result).isEqualTo("2 볼 1 스트라이크");
    }
}
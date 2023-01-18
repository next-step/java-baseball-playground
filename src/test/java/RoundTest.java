import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    Round round = new Round();
    ArrayList<Integer> answers = new ArrayList<>(Arrays.asList(1, 2, 3));

    @Test
    void 아웃테스트() {
        ArrayList<Integer> shot = new ArrayList<>(Arrays.asList(1, 5, 6));
        boolean actual = round.checkOut(answers,shot);
        assertThat(actual).isFalse();
    }

    @Test
    void 스트라이크테스트() {
        ArrayList<Integer> shot = new ArrayList<>(Arrays.asList(1, 2, 3));
        long actual = round.checkStrike(answers,shot);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    void 볼테스트() {
        ArrayList<Integer> shot = new ArrayList<>(Arrays.asList(2, 5, 4));
        long actual = round.checkBall(answers,shot);
        assertThat(actual).isEqualTo(1);
    }
}
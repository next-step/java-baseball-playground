import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void generateNumbersTest() {
        int[] computerNums = baseballGame.generateNumbers();

        assertThat(computerNums.length).isEqualTo(3);
        assertThat(computerNums).doesNotHaveDuplicates();
        assertThat(computerNums).doesNotContain(0);
    }

}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void duplicateCheckTest() {
        int[] testData = {1, 2, 3};

        boolean result;

        result = baseballGame.duplicateCheck(testData, 1);
        assertThat(result).isFalse();

        result = baseballGame.duplicateCheck(testData, 4);
        assertThat(result).isTrue();
    }

    @Test
    void compareStrikeTest() {
        int[] user = {1, 2, 3};
        int[] computer = {1, 3, 5};

        int strikeCount = 0;
        for (int i = 0; i < user.length; i++) {
            strikeCount += baseballGame.compareStrike(user[i], computer[i]);
        }
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void compareBallTest() {
        int[] user = {1, 2, 3};
        int[] computer = {1, 3, 5};

        int ballCount = 0;
        for (int i = 0; i < user.length; i++) {
            ballCount += baseballGame.compareBall(user[i], computer, i);
        }
        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void nothingTest() {
        int[] user = {1, 2, 3};
        int[] computer = {4, 5, 6};

        int strikeCount = 0;
        for (int i = 0; i < user.length; i++) {
            strikeCount += baseballGame.compareStrike(user[i], computer[i]);
        }

        int ballCount = 0;
        for (int i = 0; i < user.length; i++) {
            ballCount += baseballGame.compareBall(user[i], computer, i);
        }

        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(0);

    }

    @Test
    void compareUserToComputerTest() {
        int[] user = {1, 2, 3};
        int[] computer = {1, 3, 5};

        String expected = "1 strike / 1 ball";
        String result = baseballGame.compareUserToComputer(user, computer);

        assertThat(expected).isEqualTo(result);
    }

}
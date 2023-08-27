
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.ByteArrayInputStream;
import java.util.LinkedHashSet;


public class BaseballGameTest {
    BaseballGame baseballGame;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void makeRandomNumsTest() {
        assertThat(baseballGame.makeRandomNumbers().size()).isEqualTo(3);
    }


    @ParameterizedTest
    @CsvSource(value = {"123:true", "132:false", "456:false", "312:false"}, delimiterString = ":")
    void tryAnswerTest(String input, boolean expected) {
        LinkedHashSet<Integer> testNums = new LinkedHashSet<>();
        testNums.add(1);
        testNums.add(2);
        testNums.add(3);
        assertEquals(expected, baseballGame.tryAnswer(input, testNums));
    }
}


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;


public class BaseballGameTest {
    BaseballGame baseballGame;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private LinkedHashSet<Integer> _makeTestnums() {
        LinkedHashSet<Integer> testNums = new LinkedHashSet<>();
        testNums.add(1);
        testNums.add(2);
        testNums.add(3);

        return testNums;
    }

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @Test
    void makeRandomNumsTest() {
        assertThat(baseballGame.makeRandomNumbers().size()).isEqualTo(3);
    }

    @Test
    void countBallOrStrikeTest() {
        HashMap<String, Integer> counter = new HashMap<>();
        counter.put("ball", 0);
        counter.put("strike", 0);

        //123
        LinkedHashSet<Integer> testNums = _makeTestnums();

        //32_
        baseballGame.countBallOrStrike(counter, testNums, 3, 0);
        baseballGame.countBallOrStrike(counter, testNums, 2, 1);

        assertEquals(counter.get("ball"),1);
        assertEquals(counter.get("strike"),1);
    }


    @ParameterizedTest
    @CsvSource(value = {"123:true", "132:false", "456:false", "312:false"}, delimiterString = ":")
    void tryAnswerTest(String input, boolean expected) {
        LinkedHashSet<Integer> testNums = _makeTestnums();
        assertEquals(expected, baseballGame.tryAnswer(input, testNums));
    }


}

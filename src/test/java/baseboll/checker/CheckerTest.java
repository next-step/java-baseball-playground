package baseboll.checker;


import baseboll.myTrial.second.checker.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    @Test
    void nothingCheckerTest(){
        NothingChecker nothingChecker = new NothingChecker();
        boolean nothing = nothingChecker.isNothing(0, 0);
        assertTrue(nothing);
        nothing = nothingChecker.isNothing(1,2);
        assertFalse(nothing);
    }

    @Test
    void correctCheckerTest(){
        CorrectChecker correctChecker = new CorrectChecker();
        String input = "123";
        String answer = "123";
        boolean correct = correctChecker.isCorrect(input, answer);
        assertTrue(correct);
        correct = correctChecker.isCorrect(input, "125");
        assertFalse(correct);
    }

    @Test
    void strikerCheckerTest(){
        StrikeChecker strikeChecker = new StrikeChecker();
        int strike = strikeChecker.countStrike("123", "128");
        assertEquals(2, strike);
    }

    @Test
    void ballCheckerTest(){
        BallChecker ballChecker = new BallChecker();
        int ball = ballChecker.countBall("123", "312", 0);
        assertEquals(3, ball);
    }

    @Test
    void gameCheckerCorrectTest(){
        GameChecker gameChecker = new GameChecker();
        String input = "123";
        String answer = "123";
        String checked = gameChecker.check(input, answer);
        assertEquals("정답", checked);
    }

    @Test
    void gameCheckerStrikeTest(){
        GameChecker gameChecker = new GameChecker();
        String input = "126";
        String answer = "123";
        String checked = gameChecker.check(input, answer);
        assertEquals("2스트라이크", checked);
    }

    @Test
    void gameCheckerStrikeAndBallTest(){
        GameChecker gameChecker = new GameChecker();
        String input = "132";
        String answer = "123";
        String checked = gameChecker.check(input, answer);
        assertEquals("1스트라이크2볼", checked);
    }

    @Test
    void gameCheckerNothingTest(){
        GameChecker gameChecker = new GameChecker();
        String input = "789";
        String answer = "123";
        String checked = gameChecker.check(input, answer);
        assertEquals("낫싱", checked);
    }
}
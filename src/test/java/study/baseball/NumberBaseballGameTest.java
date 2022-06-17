package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {

    NumberBaseballGame numberBaseballGame;

    @BeforeEach
    void setUp() {
        numberBaseballGame = new NumberBaseballGame();
    }

    @Test
    void 난수가_정상적으로_생성되는지_테스트() {
        //given
        Balls randomBalls = new Balls();
        //when
        randomBalls.makeRandomBalls();
        //then
        assertEquals(3, randomBalls.size());
    }

    @Test
    void 점수_초기화_테스트() {
        //given
        PlayGameResult playGameResult = new PlayGameResult(1 ,2);
        //when
        playGameResult.clear();
        //then
        assertEquals(playGameResult, new PlayGameResult(0, 0));
    }

    @Test
    void 스트라이크_테스트() {
        //given
        Ball ball1 = new Ball(1, 1);
        //when
        Ball ball2 = new Ball(1, 1);
        //then
        assertTrue(ball1.isStrike(ball2));
    }

    @Test
    void 볼_테스트() {
        //given
        Ball ball1 = new Ball(1, 1);
        //when
        Ball ball2 = new Ball(1, 2);
        //then
        assertTrue(ball1.isBall(ball2));
    }

    @Test
    void 공_만들기_테스트() {
        //given
        int numbers = 123;
        //when
        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        Balls balls = numberBaseballGame.initUserBalls(new int[]{1, 2, 3});
        //then
        System.out.println(balls.balls());
    }

//    @Test
//    void 게임종료_테스트() {
//        //given
//        int numbers = 123;
//        //when
//        Balls balls = new Balls();
//        balls.makeUserBalls(numbers);
//        Balls balls1 = new Balls();
//        balls1.makeUserBalls(123);
//        //then
//        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
//        assertTrue(numberBaseballGame.isOver(balls, balls1));
//    }
}
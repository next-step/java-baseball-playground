package study.numberBaseballGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {
    private final NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @Test
    void test() {
        numberBaseballGame.play();
    }
}
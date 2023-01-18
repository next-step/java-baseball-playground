import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    InputService is = new InputService();
    BaseballGame game = new BaseballGame();


    @Test
    void 통합테스트() throws IOException {
        game.start();

    }

    @Test
    void 정답설정테스트() {
        game.setSolution();

        assertThat(game.getSolution().size()).isEqualTo(3);
    }

}
package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    Referee referee;
    GenerateRandomNumber randomNumber;
    List<Integer> computerNumber;
    List<Integer> userNumber;

    @BeforeEach
    public void setList() {
        computerNumber = Arrays.asList(7, 1, 3);
        userNumber = Arrays.asList(1, 2, 3);
        referee = new Referee(computerNumber, userNumber);
    }

    @Test
    @DisplayName("스트라이크 카운트가 정상적으로 올라가는지 테스트")
    public void strikeCount() {
        int answer = referee.strikeCount();

        assertThat(answer).isEqualTo(1);
    }

    @Test
    @DisplayName("볼 카운트가 정상적으로 올라가는지 테스트")
    public void ballCount() {
        int answer = referee.ballCount();

        assertThat(answer).isEqualTo(1);
    }

    @Test
    @DisplayName("힌트 메시지가 출력되는지 테스트")
    public void makeHints() {
        String answer = referee.makeHint();

        assertThat(answer).isEqualTo("1볼 1스트라이크");
    }
}
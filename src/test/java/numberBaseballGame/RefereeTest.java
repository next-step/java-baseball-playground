package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    Referee referee;
    GenerateRandomNumber randomNumber;
    List<Integer> computerNumber;
    List<Integer> userNumber;

    @BeforeEach
    public void setList() {
        computerNumber = Arrays.asList(4, 2, 5);
        userNumber = Arrays.asList(4, 2, 3);
    }

    @Test
    @DisplayName("스트라이크 카운트가 정상적으로 올라가는지 테스트")
    public void strikeCount() {
        referee = new Referee(computerNumber, userNumber);

        int answer = referee.strikeCount();

        assertThat(answer).isEqualTo(2);
    }


}
package answer;

import answer.check.CheckUseAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerAnswerServiceImplTest {
    private ComputerAnswerServiceImpl computerAnswerService;

    @BeforeEach
    public void setUp(){
        computerAnswerService = new ComputerAnswerServiceImpl();
    }

    @Test
    @DisplayName("서로다른 랜덤 3자리 정답 만들기")
    public void makeAnswer() {
        int [] answer = computerAnswerService.makeAnswer();

        assertThat(answer.length).isEqualTo(3);
        assertThat(answer[0] != answer[1] && answer[1] != answer[2] && answer[2] != answer[0]).isTrue();
    }

    @Test
    @DisplayName("중복되지 않은 랜덤숫자 만들기")
    public void generateUniqueRandomNumber_success() {
        CheckUseAnswer checkUseAnswer = new CheckUseAnswer();
        checkUseAnswer.checkAnswer(1);

        int uniqueRandomNum = computerAnswerService.generateUniqueRandomNumber(checkUseAnswer);

        assertThat(uniqueRandomNum).isNotEqualTo(1);
    }
}

package study;

import numberBaseballGame.UserAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserAnswerTest {


    @Test
    @DisplayName("3자리 숫자 입력받기")
    void submitThreeDigitNumbers(){
        UserAnswer d = new UserAnswer("123");

    }

}
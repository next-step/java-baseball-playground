package answer.check;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckUseAnswerTest {

    private final int USE_NUMBER = 7;

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3,4,5,6,7,8,9})
    @DisplayName("checkUserAnswer 10까지 배열 생성")
    public void constructor_checkUserAnswer(int arg) {
        CheckUseAnswer checkUseAnswer = new CheckUseAnswer();

        assertThat(checkUseAnswer.isNotCheckedAnswer(arg)).isTrue();
    }

    @Test
    @DisplayName("checkUserAnswer 10까지 배열 생성")
    public void constructor_checkUserAnswer_size10() {
        CheckUseAnswer checkUseAnswer = new CheckUseAnswer();

        assertThatThrownBy(() ->checkUseAnswer.isNotCheckedAnswer(10))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("사용한 숫자 체크 테스트")
    public void checkUserAnswer_use() {
        CheckUseAnswer checkUseAnswer = new CheckUseAnswer();
        checkUseAnswer.checkAnswer(USE_NUMBER);

        assertThat(checkUseAnswer.isNotCheckedAnswer(USE_NUMBER)).isFalse();
    }

    @Test
    @DisplayName("사용하지 않은 숫자 체크 테스트")
    public void checkUserAnswer_notUsed(){
        CheckUseAnswer checkUseAnswer = new CheckUseAnswer();

        assertThat(checkUseAnswer.isNotCheckedAnswer(USE_NUMBER)).isTrue();
    }

}

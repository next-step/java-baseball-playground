package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundInputDtoTest {

    @Test
    @DisplayName("사용자의 입력을 받아 값을 반환한다")
    void numbers() {
        String[] userInputToken = new String[]{"1", "2", "3"};

        RoundInputDto userInputDto = RoundInputDto.from(userInputToken);

        assertThat(userInputDto.numbers()).containsExactly(1, 2, 3);
    }
    @Test
    @DisplayName("사용자의 입력 중에서 숫자가 아닌 수가 포함되어 있을 경우 예외를 발생시킨다")
    void create_throws_exception_include_not_digit_token() {
        String[] userInputToken = new String[]{"한", "/", " "};

        assertThatIllegalArgumentException().isThrownBy(() -> RoundInputDto.from(userInputToken))
                .withMessage("숫자 이외의 문자가 포함되어 있습니다");
    }
}

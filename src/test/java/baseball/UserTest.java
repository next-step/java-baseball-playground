package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    @DisplayName("유저의 인풋이 유효한 인풋인지 테스트")
    void validateUserInput(){
        User user1 = new User();
        assertThat(user1.validateInput("123")).isTrue();

    }
//    @Test
//    @DisplayName("유저의 인풋이 유효하지 않을 경우 예외 발생 테스트")
//    void inputMisMatchException(){
//        User user1 = new User();
//        assertThatThrownBy(()->user1.getInput("1233")).isInstanceOf(InputMismatchException.class).hasMessageContaining("입력값이 올바르지 않습니다.");
//    }

}

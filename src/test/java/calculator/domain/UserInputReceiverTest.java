package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputReceiverTest {

    public static final String DELIMITER = " ";

    @Nested
    @DisplayName("사용자 입력에")
    class testReceiveWhen {

        @Test
        @DisplayName("10자리 숫자, 사칙연산 이외 문자열이 포함된 경우 예외를 반환합니다.")
        public void haveWrongCharacter_throwIllegalArgumentException() {
            // given
            UserInputReceiver sut = new UserInputReceiver();

            // when & then
            assertThatThrownBy(() -> sut.receive("2 + 강", DELIMITER))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("연이어 숫자가 포함된 경우 예외를 반환합니다.")
        @Test
        public void haveSequentialDigit_throwIllegalArgumentException() {
            // given
            UserInputReceiver sut = new UserInputReceiver();

            // when & then
            assertThatThrownBy(() -> sut.receive("2 2 +", DELIMITER))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("연이어 사칙연산이 포함된 경우 예외를 반환합니다.")
        @Test
        public void haveSequentialOperator_throwIllegalArgumentException() {
            // given
            UserInputReceiver sut = new UserInputReceiver();

            // when & then
            assertThatThrownBy(() -> sut.receive("2 + +", DELIMITER))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("0자리를 초과하는 숫자 문자열이 포함된 경우 예외를 반환합니다.")
        @Test
        public void haveOver10number_throwIllegalArgumentException() {
            // given
            UserInputReceiver sut = new UserInputReceiver();

            // when & then
            assertThatThrownBy(() -> sut.receive("21000000001 + 3", DELIMITER))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}

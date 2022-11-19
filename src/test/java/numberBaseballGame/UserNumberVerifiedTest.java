package numberBaseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserNumberVerifiedTest {

    UserNumberVerified numberVerified;
    List<Integer> inputList;
    
    @ParameterizedTest
    @DisplayName("입력받은 숫자가 유효한지 검증하는 메서드 테스트")
    @ValueSource(strings = {"1234", " ", "1m", "112"})
    public void verifiedInputNumber(String param) {

        assertThatThrownBy(() -> new UserNumberVerified(param))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
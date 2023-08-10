import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class InputerTest {

    @Test
    @DisplayName("계산을 할 수식을 입력받을 수 있습니다.")
    void input() throws IOException {
        // given
        Inputer inputer = new Inputer();
        String testInput = "2 + 3 * 5 / 3"; // 테스트용 입력을 정의
        ByteArrayInputStream mock = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(mock); // 모킹된 System.in 설정

        // when
        String input = inputer.input();

        // then
        assertThat(input).isEqualTo("2 + 3 * 5 / 3");
    }

}
package baseball;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RandomNumberTest {
    @Test
    @DisplayName("랜덤 숫자의 길이가 3인지 테스트")
    void checkLength(){
        assertThat(RandomNumber.checkLength(123)).isTrue();
        assertThat(RandomNumber.checkLength(1232)).isFalse();
    }

    @Test
    @DisplayName("숫자의 범위가 1~9 사이인지 테스트")
    void checkRange(){
        assertThat(RandomNumber.checkRange(1)).isTrue();
        assertThat(RandomNumber.checkRange(9)).isTrue();
        assertThat(RandomNumber.checkRange(0)).isFalse();
        assertThat(RandomNumber.checkRange(10)).isFalse();
    }

}

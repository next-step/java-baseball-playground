import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RandomNumberTest {
    RandomNumber randomNumber = new RandomNumber();

    @Test
    @DisplayName("숫자에 0이 포함되는지를 확인합니다.")
    void getRandomNumber_doesNotContains0_true() {
        assertThat(randomNumber.getRandomNumber()).doesNotContain("0");
    }

    @Test
    @DisplayName("중복된 숫자가 들어있는지를 확인합니다.")
    void getRandomNumber_appearOneNumberTwice_false(){
        // given
        String str = randomNumber.getRandomNumber();

        // when
        long expecting = Arrays.stream(str.split("")).distinct().count();

        // Then
        assertThat(str.length()).isEqualTo(expecting);
    }
}
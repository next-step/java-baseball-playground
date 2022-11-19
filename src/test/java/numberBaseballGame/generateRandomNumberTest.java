package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class generateRandomNumberTest {

    generateRandomNumber randomNumber;

    @BeforeEach
    public void setRamdomNumber() {
        randomNumber = new generateRandomNumber();
    }

    @Test
    @DisplayName("3자리 난수가 생성되는지 테스트")
    public void randomNumberTest() {
        String random = String.valueOf(randomNumber.createRandomNumber());

        assertThat(random.length()).isEqualTo(3);
    }
}
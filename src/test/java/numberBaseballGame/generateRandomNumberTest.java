package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class generateRandomNumberTest {
    GenerateRandomNumber randomNumber;
    @BeforeEach
    public void setRamdomNumber() {
        randomNumber = new GenerateRandomNumber();
    }

    @Test
    @DisplayName("3자리 난수가 생성되는지 테스트")
    public void randomNumberTest() {
        int numberSize = 3;
        List<Integer> numberList = randomNumber.createRandomNumber();

        assertThat(numberSize).isEqualTo(numberList.size());
    }
}
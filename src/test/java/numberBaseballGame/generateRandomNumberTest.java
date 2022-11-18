package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class generateRandomNumberTest {

    generateRandomNumber randomNumber;

    @BeforeEach
    public void setRamdomNumber() {
        randomNumber = new generateRandomNumber();
    }

    @Test
    @DisplayName("1부터 10까지 난수가 생성되는지 테스트")
    public void randomNumberTest() {


    }
}
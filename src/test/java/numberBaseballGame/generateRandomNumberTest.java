package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class generateRamdomNumberTest {

    generateRamdomNumber ramdomNumber;

    @BeforeEach
    public void setRamdomNumber() {
        ramdomNumber = new generateRamdomNumber();
    }

    @Test
    @DisplayName("1부터 10까지 난수가 생성되는지 테스트")
    public void randomNumberTest() {


    }
}
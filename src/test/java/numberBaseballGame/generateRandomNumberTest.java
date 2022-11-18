package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class generateRandomNumberTest {

    generateRandomNumber randomNumber;
    List<Integer> list;

    @BeforeEach
    public void setRamdomNumber() {
        randomNumber = new generateRandomNumber();
        list = new ArrayList<>();
    }

    @Test
    @DisplayName("3자리 난수가 생성되는지 테스트")
    public void randomNumberTest() {
        list = randomNumber.createRandomNumber();

        assertThat(list.size()).isEqualTo(3);
    }
}
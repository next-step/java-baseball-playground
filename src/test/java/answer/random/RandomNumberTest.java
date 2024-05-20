package answer.random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static answer.random.RandomNumber.generateRandomNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {


    @Test
    @DisplayName("랜덤번호 int형 생성 ")
    public void randomNumber_integer() {
        assertThat(generateRandomNumber()).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("1~9 사이 랜덤번호 생성")
    public void randomNumber_oneToTen() {
        int randomNumber = generateRandomNumber();
        Assertions.assertThat(randomNumber).isBetween(1, 9);
    }
}

package baseball.domain;

import baseball.RandomNumberGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumbersTest {

    @DisplayName("컴퓨터 리스트는 RandomGenerator의 구현체로 생성됩니다.")
    @Test
    void generateNumbers() {
        ComputerNumbers computerNumbers = new ComputerNumbers(new RandomNumberGeneratorImpl());
    }
}
package baseballgame.model.computer.domain;

import baesballgame.model.computer.domain.Computer;
import baesballgame.model.computer.domain.vo.RandomNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    @DisplayName("컴퓨터가 랜덤한 숫자 3개를 생성하는지 테스트")
    void createRandomNumber() {
        Computer computer = new Computer();

        computer.createRandomNumber();
        final int result = computer.getRandomNumber();
        final int resultLength = String.valueOf(result).length();

        Assertions.assertThat(resultLength).isEqualTo(3);
    }
}
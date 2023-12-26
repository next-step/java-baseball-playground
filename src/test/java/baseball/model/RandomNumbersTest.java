package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class RandomNumbersTest {

    @Test
    @DisplayName("랜덤한 숫자 3개 생성한다.")
    void createRandomNumbersSize() {

        //given
        RandomNumbers randomNumbers = new RandomNumbers();
        BaseballNumbers computerNumbers = new BaseballNumbers(randomNumbers.create());

        //when
        List<BaseballNumber> numbers = computerNumbers.getNumbers();

        //then
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }
}
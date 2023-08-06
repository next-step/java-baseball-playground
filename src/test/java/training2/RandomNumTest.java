package training2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumTest {

    @Test
    @DisplayName("랜덤 숫자 확인 / 중복되지 않는 3자리 확인")
    void createRandomNum() {

        RandomNum randomNum = new RandomNum();

        List<Integer> list = randomNum.createRandomNum();

        //3자리 확인
        assertThat(randomNum.createRandomNum().size()).isEqualTo(3);

        //중복수 여부 확인
        assertThat(randomNum.createRandomNum().size()).isEqualTo(list.stream().distinct().count());
    }
}
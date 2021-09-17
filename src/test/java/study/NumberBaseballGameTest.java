package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.basball.domain.NumberGenerator;

public class NumberBaseballGameTest {

    @Test
    @DisplayName("랜덤한 숫자 3개 생성")
    void randomNumberCount() {
        NumberGenerator randomNumbers =  new NumberGenerator();
        System.out.println(randomNumbers.createRandomNumbers());
        Assertions.assertThat(randomNumbers.createRandomNumbers().size()).isEqualTo(3);
    }
    
}

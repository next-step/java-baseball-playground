package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballGameTest {

    @Test
    @DisplayName("랜덤한 숫자 3개 생성")
    void randomNumberCount() {
       RandomNumbers randomNumbers =  new RandomNumbers();
        
        Assertions.assertThat(randomNumbers.answerNumbers().size()).isEqualTo(3);
    }
    
}

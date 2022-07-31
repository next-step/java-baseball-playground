package StringSplit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OutPutViewTest {

    OutPutView outPutView = new OutPutView();

    @Test
    @DisplayName("더하기 테스트")
    void plusTest(){
        assertThat(outPutView.plus(0,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest(){
        assertThat(outPutView.minus(0,1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divisonTest(){
        assertThat(outPutView.division(1,1)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void mutiplyTest(){
        assertThat(outPutView.multiply(0,1)).isEqualTo(0);
    }
}
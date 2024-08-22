package baseballgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseballgameControllerTest {

    BaseballgameController baseballgameController = new BaseballgameController();

    @Test
    @DisplayName("랜덤 세자리수 생성")
    void randomNumber() {

        //given
        int[] result = new int[3];
        result = baseballgameController.randomNumber();

        //when
        //1. 3자리인지
        assertNotNull(result.length);
        assertThat(result.length).isEqualTo(3);

        //2. 숫자에 중복이 없는지
        assertThat(result).doesNotHaveDuplicates();

        //3. 1~9자리수인지
        assertThat(result).contains(1,2,3,4,5,6,7,8,9);
    }

    @Test
    @DisplayName("숫자야구 게임 결과 확인용")
    void evaluateCondition() {
        baseballgameController = new BaseballgameController();
        baseballgameController.strike = 2;
        baseballgameController.ball = 0;

        String result = baseballgameController.evaluateCondition();
        String comparisonResult = baseballgameController.strike + "스트라이크";
        assertThat(result).isEqualTo(comparisonResult);
    }

    @Test
    @DisplayName("컴퓨터 랜덤 숫자와 사용자 입력 숫자 비교 메서드")
    void numberCompare() {
        baseballgameController = new BaseballgameController();
        baseballgameController.strike = 0;
        baseballgameController.ball = 0;

        int[] randomNumber = {1,2,3};
        int inputNumber = 2;
        int i = 1;
        baseballgameController.numberCompare(randomNumber, inputNumber ,i);
        assertThat(baseballgameController.strike).isEqualTo(1);
    }


}

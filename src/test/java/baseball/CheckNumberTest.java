package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckNumberTest {
    CheckNumber checkNumber = new CheckNumber();
    @Test
    void checkAllStrike() {
        List<Integer> computerNumberList = List.of(1,2,3);
        int[] userNumber = {1,2,3};
        int result = checkNumber.checkNumber(computerNumberList,userNumber);
        assertThat(result).isEqualTo(30);
    }
    @Test
    void checkAllNothing(){
        List<Integer> computerNumberList = List.of(1,2,3);
        int[] userNumber = {4,5,6};
        int result = checkNumber.checkNumber(computerNumberList,userNumber);
        assertThat(result).isEqualTo(0);
    }
    @Test
    void checkAllBall(){
        List<Integer> computerNumberList = List.of(1,2,3);
        int[] userNumber = {2,3,1};
        int result = checkNumber.checkNumber(computerNumberList,userNumber);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void isCorrect() {
        List<Integer> computerNumberList = List.of(1,2,3);
        int result = checkNumber.isCorrect(computerNumberList,1,0);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void isNotCorrect() {
        List<Integer> computerNumberList = List.of(1,2,3);
        int result = checkNumber.isCorrect(computerNumberList,4,0);
        assertThat(result).isEqualTo(0);
    }



}
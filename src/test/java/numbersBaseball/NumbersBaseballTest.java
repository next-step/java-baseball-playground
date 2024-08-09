package numbersBaseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static numbersBaseball.NumbersBaseball.compareTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class NumbersBaseballTest {
    // 각 자리수 비교 테스트
    @Test
    void compareToTest() {
        // given
        int[] randomNum = new int[3];
        InputView.makeRandomNumber(randomNum);


        ArrayList<Integer> sameList = new ArrayList<>();
        for (int x:
             randomNum) {
            sameList.add(x);
        }

        // expected
        // strike의 개수가 0 이상?
        assertEquals(compareTo(sameList), 3);

    }

}
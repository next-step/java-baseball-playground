package baseballgameTest;

import baseballgame.Judgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgementTest {
    private Judgement judgement;
    @BeforeEach
    void generateInstance () {
        judgement = new Judgement();
    }

    @Test
    void isContainNumberTest() {
        ArrayList<Integer> computerNums = new ArrayList<Integer>();
        ArrayList<Integer> userNums = new ArrayList<Integer>();

        computerNums.add(1);
        computerNums.add(2);
        computerNums.add(3);

        userNums.add(1);
        userNums.add(3);
        userNums.add(2);

        int result = judgement.isContainNumber(computerNums,userNums);

        assertEquals(3,result);

    }

    @Test
    void isCheckNumberTest () {
        ArrayList<Integer> computerNums = new ArrayList<Integer>();
        computerNums.add(1);
        computerNums.add(4);
        computerNums.add(9);

        assertThat(judgement.isCheckNumber(computerNums,0,1)).isTrue();
        assertThat(judgement.isCheckNumber(computerNums,0,4)).isFalse();
    }

}

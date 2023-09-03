import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {
    /**
     * 확인해야할 내용
     * 1. 1~9 사이의 난수
     * 2. 난수 3개
     * 3. 안겹치는지
     */
    private RandomGenerator randomGenerator = null;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @Test
    void isNumBetween1and9() {
        int randomNum = randomGenerator.getRandomNum();
        System.out.println(randomNum);
        assertTrue(randomNum >= 1);
        assertTrue(randomNum <=9);
    }

    @Test
    void isNumsSizeEquals3() {
        assertTrue(randomGenerator.createRandomNums().size()==3);
    }

    @Test
    void checkUniqueNum(){
        LinkedHashSet<Integer> randomNums = randomGenerator.createRandomNums();
        System.out.println(randomNums);
        for (Integer num : randomNums) {
            assertTrue(Collections.frequency(randomNums, num)==1);
        }
    }
}

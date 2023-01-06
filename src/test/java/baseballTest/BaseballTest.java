package baseballTest;

import baseball.Baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseballTest {
    private Baseball baseball = new Baseball();
    @Test
    @DisplayName("난수 발생 테스트")
    void randomTest() {
        List<String> list = baseball.random();
        System.out.println(list.size());
    }
}

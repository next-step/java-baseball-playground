package baseballTest;

import baseball.Baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BaseballTest {
    private Baseball baseball = new Baseball();
    @Test
    @DisplayName("난수 발생 테스트")
    void randomTest() {
        List<String> list = baseball.random();
        System.out.println(list.size());
    }

    @Test
    @DisplayName("리스트에 0이 포함되는 경우, 에러메세지 발생")
    void zeroCheckTest() {
        List<String> zeroO = new ArrayList<>();
        zeroO.add("0");

        assertThatThrownBy(() -> baseball.zeroCheck(zeroO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 입력할 수 없습니다.");
    }
}

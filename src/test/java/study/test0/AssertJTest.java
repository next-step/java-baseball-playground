package study.test0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTest {

    @Test
    @DisplayName("특정 위치의 문자를 가져온다.")
    void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 3, Size: 3"); // 에러 메시지가 다음 값을 포함하고 있는지 검사함
    }


}

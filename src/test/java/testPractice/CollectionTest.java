package testPractice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CollectionTest {

    @Test
    @DisplayName("입력값 범위 밖일 경우 StringIndexOutOfBoundsException 발생 여부 테스트")
    void charAt() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(str.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(str.length()));
    }
}

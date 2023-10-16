package exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Junit5ExceptionTest {

    @Test
    @DisplayName("asserThrows의 두 번째 인자인 ThrowingException.func()을 실행해서" +
            "첫 번째 인자인 RuntimeException과 같은지 또는 캐스팅이 가능한 상속 관계의 예외인지 검사한다.")
    void exceptionTest1() {
        assertThrows(RuntimeException.class, ThrowingException::func);
    }

    @Test
    @DisplayName("assertj의 assertThatThrownBy에 예외 테스트를 원하는 코드를 작성하고" +
            "isInstanceOf에는 발생하는 예외 타입 또는 부모 타입의 예외를 작성하여 테스트한다.")
    void exceptionTest2() {
        assertThatThrownBy(ThrowingException::func).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("try catch문을 사용하기." +
            "예외 메시지는 변하기 쉬운 값이기 때문에 테스트를 하지 않는 것이 좋다.")
    void exceptionTest3() {
        try {
            ThrowingException.func();
        } catch (RuntimeException e) {
            assertEquals("This is exception message", e.getMessage());
        }
    }

    @Test
    @DisplayName("assertThrows 반환값 사용하기.")
    void exceptionTest4() {
        Throwable exception = assertThrows(RuntimeException.class, ThrowingException::func);
        assertEquals("This is exception message", exception.getMessage());
    }

    @Test
    @DisplayName("assertThrows를 사용해서 SupraException이 RuntimeException 타입인지 테스트")
    void exceptionTest5() {
        assertThrows(RuntimeException.class, ThrowingException::isThatSupra);
    }
}

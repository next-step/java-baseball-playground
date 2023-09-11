package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberSupplierTest {
    InputNumberSupplier inputNumberSupplier;

    @Test
    @DisplayName("문자열 리스트를 숫자로 잘 리턴하는지를 확인합니다.")
    void getNumberList_isInputNumberValid_true() {
        String number = "123";
        inputNumberSupplier = new InputNumberSupplier(number);
        assertThat(inputNumberSupplier.getNumberList()).containsExactly(1,2,3);
    }

    @Test
    @DisplayName("중복된 숫자가 발생했을 때, 예외를 발생하는지를 확인합니다.")
    void inputNumberSupplier_hasNotDuplicate_true() {
        String number = "112";
        assertThatThrownBy(() -> new InputNumberSupplier(number))
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("1부터 9 사이의 숫자만 들어가는지를 확인합니다.")
    void inputNumberSupplier_isValidNumber_true() {
        String number = "102";
        assertThatThrownBy(() -> new InputNumberSupplier(number))
                .hasMessageContaining("1부터 9");
    }
}
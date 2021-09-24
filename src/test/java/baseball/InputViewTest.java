package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void initAll() {
        inputView = new InputView();
    }

    @Test
    @DisplayName(value = "input value test")
    void inputTest() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] s = inputView.Input();
        assertThat(s).contains("1", "2", "3");
    }
}
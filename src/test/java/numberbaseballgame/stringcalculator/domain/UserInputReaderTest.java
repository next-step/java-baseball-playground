package numberbaseballgame.stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInputReaderTest {

    UserInputReader userInputReader = new UserInputReader();

    @Test
    void splitBy() {
        assertThat(userInputReader.splitBy("1 + 2 * 3", " "))
                .contains("1", "+", "2", "*", "3");
    }
}
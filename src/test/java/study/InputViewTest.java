package study;

import baseball.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    @Test
    void toList(){
        InputView view = new InputView();

        List<Integer> result = view.toList("124");
        assertThat(result).isEqualTo(Arrays.asList(1,2,4));
    }
}

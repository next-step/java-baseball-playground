package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallTest {

    private static BaseBall baseBall;
    private static InputView inputView;

    @BeforeAll
    static void initAll() {
        baseBall = new BaseBall();
        inputView = new InputView();
    }

    @Test
    void SetComputer() {
        baseBall.Init();
        baseBall.SetComputer();
        Arrays.stream(baseBall.getComputer()).forEach((n) -> System.out.println(n));
        assertThat(baseBall.getComputer()).doesNotHaveDuplicates();
    }

    @Test
    void strike() {
        baseBall.Init();
        baseBall.SetComputer();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] s = inputView.Input();
        baseBall.SetPlayer(s);
        System.out.println();
        Arrays.stream(baseBall.getPlayer()).forEach(a -> System.out.print("player -> " + a + " "));
        Arrays.stream(baseBall.getComputer()).forEach(a -> System.out.print("computer -> " + a + " "));
        assertThat(baseBall.getPlayer()).isNotEmpty();
        assertThat(baseBall.Strike()).isGreaterThan(0);
    }

    @Test
    void ball() {
        baseBall.Init();
        baseBall.SetComputer();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] s = inputView.Input();
        baseBall.SetPlayer(s);
        System.out.println();
        Arrays.stream(baseBall.getPlayer()).forEach(a -> System.out.print("player -> " + a + " "));
        Arrays.stream(baseBall.getComputer()).forEach(a -> System.out.print("computer -> " + a + " "));
        assertThat(baseBall.getPlayer()).isNotEmpty();
        assertThat(baseBall.Ball()).isGreaterThan(0);
    }
}
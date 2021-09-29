package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBallTest {

    @Test
    void 컴퓨터_랜덤_3개_숫자_입력() {
        Computer com = new Computer();
        assertThat(com.getList().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_랜덤_중복_제외_3개_숫자_입력() {
        Computer com = new Computer();
        com.getList().stream().forEach(System.out::println);
        assertThat(com.getList().stream().distinct().count()).isEqualTo(3);
    }
}

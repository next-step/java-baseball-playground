package CarRacingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void getNameTest() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void getPositionTest() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

}

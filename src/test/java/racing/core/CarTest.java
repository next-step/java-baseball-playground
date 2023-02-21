package racing.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void moveTest1() {
        Car car = new Car("tester", () -> true);

        car.move();

        assertThat(car.positionedAt(1)).isTrue();
        assertThat(car.toString()).isEqualTo("tester : -");
    }

    @Test
    void moveTest2() {
        Car car = new Car("tester", () -> true);

        car.move();
        car.move();

        assertThat(car.positionedAt(2)).isTrue();
        assertThat(car.toString()).isEqualTo("tester : --");
    }

    @Test
    void moveTest3() {
        Car car = new Car("tester", () -> false);

        car.move();

        assertThat(car.positionedAt(0)).isTrue();
        assertThat(car.toString()).isEqualTo("tester : ");
    }
}
package racing.core;

public class Car {
    private final String name;
    private final Driver driver;
    private int position;

    public Car(String name, Driver driver) {
        this.name = name;
        this.driver = driver;
        this.position = 0;
    }

    public void move() {
        if (driver.shouldMove()) {
            ++this.position;
        }
    }

    public boolean positionedAt(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(position);
    }
}

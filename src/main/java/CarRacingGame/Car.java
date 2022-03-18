package CarRacingGame;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int drive() {
        FowardCondition fowardCondition = new FowardCondition();
        if(fowardCondition.getCondition() >= 4) {
            this.forward();
        }
        return position;
    }

    private void forward() {
        position++;
    }
}

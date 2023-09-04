import lombok.Getter;

@Getter
public class Ball {
    private int position;
    private int number;

    public Ball() {
        new Ball();
    }
    public Ball(int position, int number) {
        this.position= position;
        this.number = number;
    }

}

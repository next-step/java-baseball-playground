package baseball;

public class Ball {
    int position;
    int value;

    public Ball(int i, int i1) {
        this.position = i;
        this.value = i1;
    }

    public BallStatus play(int position, int value) {
        if(this.position == position && this.value == value){
            return BallStatus.STRIKE;
        }
        if(this.value == value){
            return BallStatus.BALL;
        }
        return BallStatus.NOTING;
    }


}

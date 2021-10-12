package baseball;

public class Ball {
    private final int pos;
    private final int num;

    public Ball(int pos, int num) {
        this.pos = pos;
        this.num = num;
    }

    @Override
    public boolean equals(Object o){
        Ball inputBall = (Ball)o;
        if(this.pos== inputBall.pos && this.num==inputBall.num ){
            return true;
        }
        return false;
    }
}

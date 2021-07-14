package baseball;


import java.util.Objects;

public class Ball {

    private final BallNum ballNum;
    private final int slotNumber;

    
    public Ball(BallNum ballNum, int slotNumber) {
        this.ballNum = ballNum;
        this.slotNumber = slotNumber;
    }


    public String getBallNum() {
        return ballNum.getInNumber();
    }

    public int getSlotNumber() {
        return slotNumber;
    }
    //    private static boolean isInt(String inNumber) {
//        //matches (regex, string val)
//        return Pattern.matches("^[0-9]*$",inNumber);
//    }

    //BallGame 아닌, Ball의 메서드
    public boolean isSameSlotOf(Ball usrBall) {
        return this.slotNumber == usrBall.getSlotNumber();
    }

    //String num so .equals()
    public boolean isSameNumOf(Ball usrBall) {
        return this.ballNum.getInNumber().equals(usrBall.getBallNum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return slotNumber == ball.slotNumber &&
                Objects.equals(ballNum, ball.ballNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNum, slotNumber);
    }
}

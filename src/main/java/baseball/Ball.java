package baseball;


import java.util.Objects;

public class Ball {

    private final String ballNum;
    private final int slotNumber;

    public Ball(String inNumber) {
        //this constructor 상속 (임시)
        this (inNumber, 1);
    }
    
    public Ball(String inNumber, int slotNumber) {
        this.ballNum = makeBallnum(inNumber);
        this.slotNumber = slotNumber;
    }

    public static String makeBallnum(String inNumber) throws IllegalArgumentException {
//        if (isInt(inNumber)) {
//            throw new IllegalArgumentException("isNotaNumber");
//        }
        if (!isInRange(Integer.parseInt(inNumber))) {
            throw new IllegalArgumentException("isNotInRange");
        }
        return inNumber;
    }

    private static boolean isInRange(int parsedNumber) {
        return parsedNumber >= 1 && parsedNumber <= 9;
    }


    public String getBallNum() {
        return ballNum;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
    //    private static boolean isInt(String inNumber) {
//        //matches (regex, string val)
//        return Pattern.matches("^[0-9]*$",inNumber);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return slotNumber == ball.slotNumber &&
                Objects.equals(ballNum, ball.ballNum);
    }

    //BallGame 아닌, Ball의 메서드
    public boolean isSameSlotOf(Ball usrBall) {
        return this.slotNumber == usrBall.getSlotNumber();
    }

    //String num so .equals()
    public boolean isSameNumOf(Ball usrBall) {
        return this.ballNum.equals(usrBall.getBallNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNum, slotNumber);
    }

}

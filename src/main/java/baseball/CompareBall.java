package baseball;

import java.util.Iterator;

public class CompareBall {
    CreateComputerBall computerBall = new CreateComputerBall();
    CreatePlayerBall playerBall = new CreatePlayerBall();
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    void strikeCheck() {

        Iterator<Integer> ir = computerBall.getHashSet().iterator();

        String firtstNum = playerBall.getManChoose().substring(0, 1);
        String secondNum = playerBall.getManChoose().substring(1, 2);
        String thirdNum = playerBall.getManChoose().substring(2, 3);

        Integer num1 = ir.next();
        Integer num2 = ir.next();
        Integer num3 = ir.next();


        if (num1.compareTo(Integer.valueOf(firtstNum)) == 0) {
            strike++;
        }
        if (num2.compareTo(Integer.valueOf(secondNum)) == 0) {
            strike++;
        }
        if (num3.compareTo(Integer.valueOf(thirdNum)) == 0) {
            strike++;
        }


    }

    void ballCheck() {
        String firtstNum = playerBall.getManChoose().substring(0, 1);
        String secondNum = playerBall.getManChoose().substring(1, 2);
        String thirdNum = playerBall.getManChoose().substring(2, 3);
        Iterator<Integer> ir = computerBall.getHashSet().iterator();

        Integer num1 = ir.next();
        Integer num2 = ir.next();
        Integer num3 = ir.next();

        if (num1.compareTo(Integer.valueOf(firtstNum)) != 0 &&
                num1.compareTo(Integer.valueOf(secondNum)) == 0 ||
                num1.compareTo(Integer.valueOf(thirdNum)) == 0
        ) ball++;
        if (num2.compareTo(Integer.valueOf(secondNum)) != 0 &&
                num2.compareTo(Integer.valueOf(firtstNum)) == 0 ||
                num2.compareTo(Integer.valueOf(thirdNum)) == 0
        ) ball++;
        if (num3.compareTo(Integer.valueOf(thirdNum)) != 0 &&
                num3.compareTo(Integer.valueOf(secondNum)) == 0 ||
                num3.compareTo(Integer.valueOf(firtstNum)) == 0
        ) ball++;
    }


}

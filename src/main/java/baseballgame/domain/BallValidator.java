package baseballgame.domain;

import java.util.regex.Pattern;

public class BallValidator {
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 1;


    public static boolean isValid(int ballNumber) throws RuntimeException{
        return checkBallNumberHasValidScope(ballNumber);
    }

    private static boolean checkBallNumberHasValidScope(int ballNumber){
        if(!(ballNumber >= 1 && ballNumber<10)){
            throw new RuntimeException("유요한 숫자 범위가 아닙니다");
        }
        return true;
    }
}

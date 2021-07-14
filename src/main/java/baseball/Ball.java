package baseball;


public class Ball {

    private final String ballNum;

    public Ball(String inNumber) {
        this.ballNum = makeBallnum(inNumber);
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

//    private static boolean isInt(String inNumber) {
//        //matches (regex, string val)
//        return Pattern.matches("^[0-9]*$",inNumber);
//    }
}

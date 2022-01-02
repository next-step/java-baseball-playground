package baseball;

import java.util.Random;

public class Baseball {

    public boolean doubleCheck(int createNumber, int checkNumber) {
        return createNumber != checkNumber;
    }

    public boolean threepleCheck(int createNumber, int checkNumberOne, int checkNumberTwo) {
        if (!doubleCheck(createNumber, checkNumberOne)) {
            return (false);
        }
        return doubleCheck(createNumber, checkNumberTwo);
    }

    public int setThirdNumber(int first, int second) {
        Random random = new Random();
        int third = random.nextInt(9) + 1;

        while (!threepleCheck(third, first, second)) {
            third = random.nextInt(9) + 1;
        }
        return (third);
    }

    public int setSecondNumber(int first) {
        Random random = new Random();
        int second = random.nextInt(9) + 1;

        while (!doubleCheck(second, first)) {
            second = random.nextInt(9) + 1;
        }
        return (second);
    }

    public int[] setUpAnswer() {
        Random random = new Random();
        int[] answer = new int[3];

        answer[0] = random.nextInt(9) + 1;
        answer[1] = setSecondNumber(answer[0]);
        answer[2] = setThirdNumber(answer[0], answer[1]);
        return (answer);
    }

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        int[] answer = new int[3];

        answer = baseball.setUpAnswer();
    }
}

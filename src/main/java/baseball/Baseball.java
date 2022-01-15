package baseball;

import java.util.Random;

public class Baseball {

    RoundElement roundElement = new RoundElement();
    ResultView resultView = new ResultView();
    InputView inputView = new InputView();

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

    public void checkFirstBall(int[] answer, int firstInputString) {
        if (answer[0] == firstInputString) {
            roundElement.strike++;
            return;
        }
        if (answer[1] == firstInputString || answer[2] == firstInputString) {
            roundElement.ball++;
        }
    }

    public void checkSecondBall(int[] answer, int secondInputString) {
        if (answer[1] == secondInputString) {
            roundElement.strike++;
            return;
        }
        if (answer[0] == secondInputString || answer[2] == secondInputString) {
            roundElement.ball++;
        }
    }

    public void checkThirdBall(int[] answer, int thirdInputString) {
        if (answer[2] == thirdInputString) {
            roundElement.strike++;
            return;
        }
        if (answer[0] == thirdInputString || answer[1] == thirdInputString) {
            roundElement.ball++;
        }
    }

    public void parseRound(int[] answer, String inputString) {
        roundElement.strike = 0;
        roundElement.ball = 0;
        checkFirstBall(answer, Character.getNumericValue(inputString.charAt(0)));
        checkSecondBall(answer, Character.getNumericValue(inputString.charAt(1)));
        checkThirdBall(answer, Character.getNumericValue(inputString.charAt(2)));
    }

    public void printResult() {
        if (roundElement.strike == 3) {
            System.out.println("3 strike");
            resultView.printFinishMsg();
            return;
        }
        if (roundElement.ball > 0 && roundElement.strike > 0) {
            System.out.printf("%d ball, %d strike\n", roundElement.ball, roundElement.strike);
            return;
        }
        if (roundElement.ball > 0 && roundElement.strike == 0) {
            System.out.printf("%d ball\n", roundElement.ball);
            return;
        }
        if (roundElement.ball == 0 && roundElement.strike > 0) {
            System.out.printf("%d strike\n", roundElement.strike);
            return;
        }
        if (roundElement.ball == 0) {
            System.out.println("Nothing\n");
            return;
        }
    }

    public boolean gameStart(int[] answer) {
        String inputString;

        roundElement.strike = 0;
        roundElement.ball = 0;
        while (!(roundElement.strike == 3)) {
            inputString = inputView.printAskNumberMsg();
            parseRound(answer, inputString);
            printResult();
        }
        inputString = inputView.printAskRestartMsg();
        if (inputString.equals("yes")) {
            return (false);
        }
        return (true);
    }

    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        int[] answer = new int[3];
        boolean exitKey = false;

        while (!exitKey) {
            answer = baseball.setUpAnswer();
            exitKey = baseball.gameStart(answer);
        }
    }
}
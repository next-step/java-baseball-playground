package baesballgame.model.computer.service;

import baesballgame.model.computer.domain.Computer;
import baesballgame.model.computer.dto.ResponseResult;

public class CheckService {

    private final Computer computer;

    public CheckService() {
        this.computer = new Computer();
    }

    public void createRandomNumber() {
        computer.createRandomNumber();
    }

    public ResponseResult play(int requestNumber) {
        int randomNumber = computer.getRandomNumber();

        String stringRequestNumber = String.valueOf(requestNumber);
        String stringRandomNumber = String.valueOf(randomNumber);

        int strike = checkStrike(stringRequestNumber, stringRandomNumber);
        int ball = checkBall(stringRequestNumber, stringRandomNumber);

        return new ResponseResult(ball, strike);
    }

    private static int checkStrike(String stringRequestNumber, String stringRandomNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (stringRequestNumber.charAt(i) == stringRandomNumber.charAt(i)) strike++;
        }

        return strike;
    }

    private static int checkBall(String stringRequestNumber, String stringRandomNumber) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            ball = checkRow(stringRequestNumber, stringRandomNumber, ball, i);
        }

        return ball;
    }

    private static int checkRow(String stringRequestNumber, String stringRandomNumber, int ball, int i) {
        for (int j = 0; j < 3; j++) {
            if (i == j) continue;
            if (stringRequestNumber.charAt(i) == stringRandomNumber.charAt(j)) ball++;
        }

        return ball;
    }
}

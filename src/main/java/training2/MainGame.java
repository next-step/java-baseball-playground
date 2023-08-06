package training2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        RandomNum randomNum = new RandomNum();
        List<Integer> computer = randomNum.createRandomNum();
        boolean pass = false;
        Input in = new Input();
        ResultJudge result = new ResultJudge();

        while (true) {
            in.inputScanner(pass);
            pass = result.resultJudge(computer, in.getPlayerNum());
            if (pass) {
                computer = randomNum.createRandomNum();
            }
        }

    }
}

import baseballgame.Generator;
import baseballgame.InputNumber;
import baseballgame.Refree;
import baseballgame.View;

import java.util.ArrayList;

public class NumberBaseBallApp {
    public static void main (String [] args) {
        String reInput;

        do {
            Generator g = new Generator();
            InputNumber input = new InputNumber();
            Refree refree = new Refree();
            View view = new View();

            ArrayList<Integer> computer = g.generateComputerNum();

            while (refree.strike != 3) {
                ArrayList<Integer> user = InputNumber.validNum(input.inputUserNum());
                refree.makeCall(computer, user);
                view.response(refree.strike, refree.ball);
            }

            reInput = view.gameSet();
        } while (reInput.equals("1"));
    }
}

import baseballgame.Generator;

import java.util.ArrayList;

public class NumberBaseBallApp {
    public static void main (String [] args) {
        Generator generator = new Generator();
        ArrayList computerNum = generator.generateComputerNum();
        System.out.println(computerNum);
    }
}

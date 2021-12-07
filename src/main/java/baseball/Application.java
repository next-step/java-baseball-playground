package baseball;

import baseball.domain.NumberGenerator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        ArrayList<Integer> comNums = numberGenerator.makeThreeNumbersByCom();
    }

    public static ArrayList<Integer> receiveInputFromUser() {
        return null;
    }
}

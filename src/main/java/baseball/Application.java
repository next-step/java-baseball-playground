package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        ArrayList<Integer> comNums = numberGenerator.makeThreeNumbersByCom();
        Referee referee = new Referee();
        }
    }

    public static ArrayList<Integer> receiveInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayList<Integer> givenInputs = new ArrayList<>();
        for (String givenInput : input.split("")) {
            givenInputs.add(Integer.parseInt(givenInput));
        }
        return givenInputs;
    }
}

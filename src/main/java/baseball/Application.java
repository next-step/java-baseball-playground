package baseball;

import baseball.domain.GamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        int startGame = 1;
        while (!(startGame == 2)) {
            startGame = player.playGame();
        }
    }

    public static List<Integer> receiveInputFromUser() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> givenInputs = new ArrayList<>();
        for (String givenInput : input.split("")) {
            givenInputs.add(Integer.parseInt(givenInput));
        }
        return givenInputs;
    }
}

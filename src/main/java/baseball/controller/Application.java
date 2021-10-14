package baseball.controller;

import baseball.controller.GameController;


public class Application {
    public static void main(String[] args) {
        GameController computer = new GameController();
        computer.run();
    }
}

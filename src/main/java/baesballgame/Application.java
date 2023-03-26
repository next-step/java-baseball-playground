package baesballgame;

import baesballgame.model.computer.controller.ViewController;

public class Application {
    public static void main(String[] args) {
        ViewController controller = new ViewController();

        controller.play();
    }
}
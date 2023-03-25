package baseball;

import baseball.controller.BaseballController;

public class BaseballApp {
    public static void main(String[] args) {
        BaseballController baseballController = BaseballConfig.set();
        baseballController.start();
    }
}

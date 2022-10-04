package baseballgame.domain;

import baseballgame.domain.controller.BaseBallGameController;
import baseballgame.domain.util.NumberGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args){
        BaseBallGameController controller = new BaseBallGameController();
        controller.play();
//        NumberGenerator numberGenerator = new NumberGenerator();
//        List<Integer> numbers = numberGenerator.createRandomNumbers();
//        System.out.println(numbers);
    }
}

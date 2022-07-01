package baseballgame;

import java.util.Set;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        Set<Integer> computer = numberGenerator.createNumbers();
        System.out.println(computer);
    }
}

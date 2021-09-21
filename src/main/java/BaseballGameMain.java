public class BaseballGameMain {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String finish = "";

        do {

            int[] computer = baseballGame.generateNumbers();
            while (!finish.equals("3 strike")) {
                finish = baseballGame.compareUserToComputer(baseballGame.inputNumber(), computer);
                System.out.println(finish);
            }
            finish = baseballGame.finishQuestion();

        } while (finish.equals("1"));
    }
}
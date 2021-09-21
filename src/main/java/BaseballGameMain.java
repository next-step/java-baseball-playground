public class BaseballGameMain {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        int[] computer = baseballGame.generateNumbers();

        while (true) {
            int[] user = baseballGame.inputNumber();

            for (int num : computer) {
                System.out.print(num);
            }

            System.out.println();

            for (int num : user) {
                System.out.print(num);
            }

            System.out.println();
            System.out.println(baseballGame.compareUserToComputer(user, computer));
        }
    }
}

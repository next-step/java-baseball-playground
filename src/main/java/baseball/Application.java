package baseball;

public class Application {
    public static void main(String[] args) {

        Player player = new Player(InputView.input());
        System.out.println(player.getList());
    }
}

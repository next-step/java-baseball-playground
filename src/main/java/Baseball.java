public class Baseball {
    public static void main(String[] args) {
        Player player = new Player();
        Computer com = new Computer();

        player.setNumber();

        GameConsole gameConsole = new GameConsole(player.getNumber(), com.getNumber());
        gameConsole.play();
    }
}

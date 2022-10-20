public class GameWin {
    static boolean win = false;
    public static void gameWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameRestart = InputView.scanner.nextLine();
        if (gameRestart.equals("1")) {
            restart();
        }
        if (gameRestart.equals("2")) {
            quit();
        }
    }

    public static void restart() {
        RandomNumber.selectNumbers();
    }

    public static void quit() {
        System.out.println("종료");
        win = true;
    }

}

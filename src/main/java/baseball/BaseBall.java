package baseball;

public class BaseBall {

    private boolean end = false;

    public void run() {
        Computer computer = new Computer();
        while (!isEnd()) {
            OutPutView.showResult(this,playGame(computer));
        }
    }

    private PlayResult playGame(Computer computer) {
        Player player = new Player(InputView.input());
        Balls balls = new Balls(computer.getList());
        PlayResult result = balls.play(player.getList());
        return result;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    private boolean isEnd() {
        return this.end;
    }

}

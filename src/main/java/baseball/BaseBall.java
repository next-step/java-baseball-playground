package baseball;

public class BaseBall {

    private boolean end = false;

    public void run() {
        setEnd(false);
        Computer computer = new Computer();
        while (!isEnd()) {
            OutPutView.showResult(this,playGame(computer));
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        if(!InputView.input().equals("1")) {
            return;
        }
        run();
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

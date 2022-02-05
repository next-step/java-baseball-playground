package study.mission01;


public class GameBoard {

    private int answer;


    public GameBoard() {
        this.answer = NumberGenerator.generate();
    }


    public String getHint(int guessNumber) {
        Referee referee = new Referee(answer, guessNumber);
        return referee.check();
    }

    // input number 가 정답인지 체크
    public boolean isAnswer(int guessNumber) {
        return guessNumber == getAnswer();
    }


    public int getAnswer() {
        return this.answer;
    }


    public void reset() {
        this.answer = NumberGenerator.generate();
    }
}

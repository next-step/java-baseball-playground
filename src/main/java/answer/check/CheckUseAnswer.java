package answer.check;

public class CheckUseAnswer {

    private boolean [] check;

    public CheckUseAnswer() {
        this.check = new boolean[10];
    }

    public boolean isNotCheckedAnswer(int num) {
        return !check[num];
    }

    public void checkAnswer(int num) {
        check[num] = true;
    }
}

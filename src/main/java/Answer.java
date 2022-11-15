import java.util.List;

public class Answer {

    private ResultView resultView;

    public Answer() {
        resultView = new ResultView();
    }

    public boolean correctAnswer(final List<String> randomNumbers, final List<String> number) {
        if (randomNumbers.equals(number)) {
            resultView.correct();
            return true;
        }

        return false;
    }
}

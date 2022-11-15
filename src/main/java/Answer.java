import java.util.List;

public class Answer {

    public boolean correctAnswer(final List<String> answer, final List<String> number) {
        if (answer.equals(number)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("정답은 : " + answer);
            return true;
        }

        return false;
    }
}

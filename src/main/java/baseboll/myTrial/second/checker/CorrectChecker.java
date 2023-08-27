package baseboll.myTrial.second.checker;

public class CorrectChecker extends Checker{

    public boolean isCorrect(String input, String answer){
        return input.equals(answer);
    }
}

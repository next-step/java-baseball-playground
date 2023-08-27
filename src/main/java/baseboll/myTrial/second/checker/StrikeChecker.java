package baseboll.myTrial.second.checker;

public class StrikeChecker extends Checker{
    private int checkStrike(String aInput, String aAnswer){
        return aInput.equals(aAnswer) ? 1 : 0;
    }
    public int countStrike(String input, String answer){
        String[] inputs = input.split("");
        String[] answers = answer.split("");
        int strikeCount = 0;
        for (int i = 0; i < inputs.length; i++) {
            strikeCount += checkStrike(inputs[i], answers[i]);
        }
        return strikeCount;
    }
}

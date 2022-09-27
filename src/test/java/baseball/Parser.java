package baseball;

public class Parser {

    public int[] stringToInts(String answer){
        int[] answers = new int[3];
        for (int i = 0; i < answer.length(); i++) {
            String str = String.valueOf(answer.charAt(i));
            answers[i] = Integer.parseInt(str);
        }
        return answers;
    }
}

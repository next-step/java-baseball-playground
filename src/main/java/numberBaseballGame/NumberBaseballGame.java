package numberBaseballGame;

import java.util.Random;
import java.util.Scanner;

public class NumberBaseballGame {

    private String answer;

    private Scanner scanner = new Scanner(System.in);

    public NumberBaseballGame(){
        this.answer = createAnswer();
    }

    public NumberBaseballGame(String answer){
        this.answer = answer;
    }

    private String createAnswer(){
        Random random = new Random();
        return random.ints(3).toString();
    }

    private void start(){
        int strikeCount = 0;
        int ballCount = 0;

        while (strikeCount == 3){
            String userAnswer = submitAnswer();
            System.out.println("오답입니다");
        }

        if( isRestart(submitExitValue()) ){
            restart();
        }
    }

    public String getStrikeNumbers(String userAnswer){
        String result = "";
        String[] userAnswerArray = userAnswer.split("");

        if(answer.indexOf(userAnswerArray[0]) == 0 ){
            strikeCount++;
        }

        return result;
    }

    public String getStrikeNumber(String[] userAnswerArray){

    }

    public boolean isCorrectAnswer(String userAnswer){
        return answer.equals(userAnswer);
    }
    public void restart(){
        answer = createAnswer();
        start();
    }

    public boolean isRestart(String restartFlag){
        return restartFlag.equals("1");
    }

    public String submitAnswer(){
        System.out.print("숫자를 입력해 주세요 :");
        return scanner.next();
    }

    public String submitExitValue(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작혀려면 1, 종료하려면 2를 입력하세요.");
        return scanner.next();
    }

    public static void main(String[] args) {
        NumberBaseballGame game = new NumberBaseballGame("234");
        game.start();
    }
}

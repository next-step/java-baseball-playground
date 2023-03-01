package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

public class BaseBallTest {

    Scanner scanner;

    @BeforeEach
    void setup(){

        scanner = new Scanner(System.in);

    }


    @Test
    void test(){

        String numberByComputer = generateNumberByComputer();

        gameStart(numberByComputer);


    }

    private void gameStart(String numberByComputer) {

        boolean gameStart =true;

        while(gameStart){

            InputView inputView= new InputView();

            inputView.message();

            String numberByHuman =  scanner.nextLine();

            gameStart = checkEqual(numberByComputer, numberByHuman);

        }
    }

    private boolean checkEqual(String numberByComputer, String numberByHuman) {
        if(numberByHuman.equals(numberByComputer)){

            if(checkMode()) return true;

        }
        else{

            ResultView resultView = new ResultView();

            resultView.BallMessage(countBall(numberByComputer, numberByHuman));

            resultView.BallMessage(countStrike(numberByComputer, numberByHuman));


        }

        return false;
    }

    private int countBall(String numberByComputer, String numberByHuman) {

        int result = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            for(int j = 0; j< numberByHuman.length(); j++){
                if(numberByComputer.charAt(i)== numberByHuman.charAt(j)){

                    if(i!=j)
                        result++;

                }
            }
        }
        return result;
    }

    private int countStrike(String numberByComputer, String numberByHuman) {

        int result = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            for(int j = 0; j< numberByHuman.length(); j++){
                if(numberByComputer.charAt(i)== numberByHuman.charAt(j)){

                    if(i==j)
                        result++;

                }
            }
        }
        return result;
    }

    private Boolean checkMode(){

        ResultView resultView = new ResultView();

        resultView.message();

        String mode = scanner.nextLine();

        if (mode.equals("1")) return resultView.resumeMessage();

        if (mode.equals("2")) return resultView.exitMessage();

        return true;
    }

    private static String generateNumberByComputer() {
        Random random = new Random();

        String numberByComputer = Integer.toString((int)(Math.random() * 9 + 1) * 100+ (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1));
        return numberByComputer;
    }
}

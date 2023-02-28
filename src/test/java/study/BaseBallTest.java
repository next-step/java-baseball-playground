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

        InputView inputView= new InputView();

        inputView.message();

         String numberByHuman =  scanner.nextLine();

        while(true){

            if(numberByHuman.equals(numberByComputer)){

                if(aaa()) break;

            }

        }
    }

    private Boolean aaa(){

        ResultView resultView = new ResultView();

        resultView.message();

        String mode = scanner.nextLine();

        if (mode.equals("1")) return resultView.resumeMessage();

        if (mode.equals("2")) return resultView.exitMessage();

        return false;
    }

    private static String generateNumberByComputer() {
        Random random = new Random();

        String numberByComputer = Integer.toString((int)(Math.random() * 9 + 1) * 100+ (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1));
        return numberByComputer;
    }
}

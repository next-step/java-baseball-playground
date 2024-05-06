package baseballgame;

import java.util.Scanner;

public class Regame {
    public boolean restart(){
        System.out.println("you corrected 3 number! end game");
        System.out.println("enter 1 to restart game, enter 2 to exit game");

        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);

        if(answer == '1') {
            return true;
        } else if (answer == '2') {
            return false;
        }else{
            throw new IllegalArgumentException("enter 1 or 2");
        }
    }
}

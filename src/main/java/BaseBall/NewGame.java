package BaseBall;

import java.io.IOException;
import java.util.Scanner;

public class NewGame {

    public boolean choice(){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice==1) return true;
       return false;

    }
}

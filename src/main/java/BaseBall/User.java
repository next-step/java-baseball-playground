package BaseBall;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public int[] User(){
        Scanner sc=new Scanner(System.in);
        int[] User=new int[3];
        System.out.println("숫자를 입력해 주세요 : ");
        String str=sc.nextLine();
        for (int i = 0; i < 3; i++) {
            User[i]=Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return User;
    }
}

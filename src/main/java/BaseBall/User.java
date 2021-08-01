package BaseBall;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

    public ArrayList<Integer> User(){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> User=new ArrayList<>();
        System.out.println("숫자를 입력해 주세요 : ");
        String str=sc.nextLine();
        for (int i = 0; i < 3; i++) {
            User.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        return User;
    }
}

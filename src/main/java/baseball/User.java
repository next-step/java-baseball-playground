package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    public Balls makeInput() {
        System.out.print("숫자를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        List<Integer> balls = new ArrayList<>();

        for (String num : input) {
            balls.add(Integer.valueOf(num));
        }

        Balls result = new Balls(balls);

        return result;
    }

    public boolean restartGame(){
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input);
        if(input.equals("1")){
            return true;
        }
        return false;
    }
}

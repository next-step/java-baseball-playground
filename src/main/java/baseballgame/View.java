package baseballgame;

import java.util.Scanner;

public class View {

    public void response (int strike, int ball) {
        if(strike ==0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball+" 볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike+" 스트라이크");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball+" 볼 "+strike+" 스트라이크");
        }
    }

    public String requestInput () {
        System.out.println("다시 입력해주세요");
        return new Scanner(System.in).nextLine();
    }

    public String gameSet() {
        System.out.println("정답입니다. 다시시작:1 , 종료:2 ");
        return new Scanner(System.in).nextLine();
    }
}

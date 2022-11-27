package baseball;

import java.util.*;

public class Test {
    private HashSet<Integer> hashSet;
    private Random ran;
    private String manChoose;

    private Scanner sc;

    private int strike;
    private int ball;


    Test() {
        sc = new Scanner(System.in);

        ran = new Random();
        hashSet = new HashSet<>();
        strike = 0;
        ball = 0;

    }

    void createNumber() {
        while (hashSet.size() < 3) {
            int number = ran.nextInt(9) + 1;
            hashSet.add(number);
        }
        System.out.println(hashSet);
        manChoose = sc.nextLine();
    }

    void strikeCheck() {
        Iterator<Integer> ir = hashSet.iterator();

        String firtstNum = manChoose.substring(0, 1);
        String secondNum = manChoose.substring(1, 2);
        String thirdNum = manChoose.substring(2, 3);

        Integer num1 = ir.next();
        Integer num2 = ir.next();
        Integer num3 = ir.next();


        if (num1.compareTo(Integer.valueOf(firtstNum)) == 0) {
            strike++;
        }
        if (num2.compareTo(Integer.valueOf(secondNum)) == 0) {
            strike++;
        }
        if (num3.compareTo(Integer.valueOf(thirdNum)) == 0) {
            strike++;
        }
    }

    void ballCheck() {
        Iterator<Integer> ir = hashSet.iterator();
        String firtstNum = manChoose.substring(0, 1);
        String secondNum = manChoose.substring(1, 2);
        String thirdNum = manChoose.substring(2, 3);

        Integer num1 = ir.next();
        Integer num2 = ir.next();
        Integer num3 = ir.next();

        if (num1.compareTo(Integer.valueOf(firtstNum)) != 0 &&
                num1.compareTo(Integer.valueOf(secondNum)) == 0 ||
                num1.compareTo(Integer.valueOf(thirdNum)) == 0
        ) ball++;
        if (num2.compareTo(Integer.valueOf(secondNum)) != 0 &&
                num2.compareTo(Integer.valueOf(firtstNum)) == 0 ||
                num2.compareTo(Integer.valueOf(thirdNum)) == 0
        ) ball++;
        if (num3.compareTo(Integer.valueOf(thirdNum)) != 0 &&
                num3.compareTo(Integer.valueOf(secondNum)) == 0 ||
                num3.compareTo(Integer.valueOf(firtstNum)) == 0
        ) ball++;
    }

    void result() {
        if (strike >= 1) {
            System.out.print(strike + "스트라이크"+"\n");
        }
        if(ball>=1){
            System.out.print(ball + "볼");
            System.out.println();
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
            End();
        }
    }

    void End() {
        int number = sc.nextInt();
        if (number == 2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {


        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("숫자를 입력하세요 : ");
            Test test = new Test();
            test.createNumber();
            test.strikeCheck();
            test.ballCheck();
            test.result();
        }

    }
}

package baseball;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import java.util.Scanner;
import java.util.Stack;

public class BaseBall {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    static int Computer[];

    static int Player[];

    static boolean Finish = false;
    Stack<Integer> preNum = new Stack<>();

    public static int[] getPlayer() {
        return Player;
    }

    public static int[] getComputer() {
        return Computer;
    }

    public void Init() {
        preNum.clear();
        Computer = new int[3];
        Player = new int[3];
    }

    public void run() {
        Init();
        while (!Finish) {
            String Input[] = inputView.Input();
            SetPlayer(Input);
            outputView.OutPut(this);
        }
        SetComputer();
    }

    public void CheckNumber(int[] player) {


    }

    public void SetPlayer(String[] input) {
        for (int i = 0; i < 3; i++) {
            Player[i] = Integer.parseInt(input[i]);
        }
    }

    public void SetComputer() {
        for (int i = 0; i < 3; i++) {
            setNumber(i);
        }
    }

    int RandomNumber() {
        int start = 1, end = 9;
        int randomNumber = (int) (Math.random() * end + start);
        return randomNumber;
    }

    private void setNumber(int i) {
        int number = RandomNumber();
        while (preNum.contains(number) && !preNum.isEmpty()) {
            number = RandomNumber();
            break;
        }
        Computer[i] = number;
        preNum.add(number);
    }

    public int Strike() {
        int Count = 0;
        for (int i = 0; i < 3; i++) {
            Count += CheckStrikeCount(i);
        }

        if (Count == 3) {
            Finish = true;
        }
        return Count;
    }

    private int CheckStrikeCount(int i) {
        if (Player[i] == Computer[i]) {
            return 1;
        }
        return 0;
    }

    public int Ball() {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            ballCount += CheckBallCount(i);
        }
        return ballCount;
    }

    private int CheckBallCount(int i) {
        if (preNum.contains(Player[i]) && Player[i] != Computer[i]) {
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {

    }

}

class InputView {
    public String[] Input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        return sc.nextLine().split("");
    }

    public void FinishView() {

    }
}

class OutputView {
    StringBuilder stringBuilder = new StringBuilder();

    public void OutPut(BaseBall baseBall) {
        if (baseBall.Ball() > 0) {
            stringBuilder.append(baseBall.Ball() + "볼").append(" ");
        }
        if (baseBall.Strike() > 0) {
            stringBuilder.append(baseBall.Strike() + "스트라이크").append("\n");
        }

        if (baseBall.Strike() == 3) {
            stringBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료").append("\n");
        }
    }
}
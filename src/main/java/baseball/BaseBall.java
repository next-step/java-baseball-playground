package baseball;

import com.sun.tools.jdeprscan.scan.Scan;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BaseBall {


    static int Computer[];

    static int Player[];
    private static boolean Finish = false;
    private static int FinishValue = 0;
    Stack<Integer> preNum = new Stack<>();

    public static int[] getPlayer() {
        return Player;
    }

    public static int[] getComputer() {
        return Computer;
    }


    public static boolean isFinish() {
        return Finish;
    }

    public static void setFinish(boolean finish) {
        Finish = finish;
    }

    public void Init() {
        preNum.clear();
        Computer = new int[3];
        Player = new int[3];
        setFinish(false);
        FinishValue = 0;
    }

    public void run() throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Init();
        SetComputer();
        while (!Finish) {
            String Input[] = inputView.Input();
            SetPlayer(Input);
            outputView.OutPut(this);
        }
        outputView.FinishView();
        FinishValue = inputView.FinishInput();
        while (inputView.FinishInput() > 2) {
            System.out.println("2 이하의 값을 넣어주세요");
            FinishValue = inputView.FinishInput();
        }
        if (FinishValue == 1) {
            run();
        }
        return;

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


    public static void main(String[] args) throws IOException {
        BaseBall baseBall = new BaseBall();
        baseBall.run();
    }

}

class InputView {

    public String[] Input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        return sc.nextLine().split("");
    }

    public int FinishInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

class OutputView {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void OutPut(BaseBall baseBall) throws IOException {
        BallView(baseBall);
        StrikeView(baseBall);
        NotthingView(baseBall);
        bw.flush();
    }

    private void BallView(BaseBall baseBall) throws IOException {
        if (baseBall.Ball() > 0) {
           bw.write(baseBall.Ball() + "볼 ");
        }
    }
    private void StrikeView(BaseBall baseBall) throws IOException {
        if (baseBall.Strike() == 0) {
            bw.write("\n");
            return;
        }
        bw.write(baseBall.Strike() + "스트라이크\n");

        if (baseBall.Strike() == 3) {
            baseBall.setFinish(true);
            FinishView();
        }
    }

    private void NotthingView(BaseBall baseBall) throws IOException {
        if (baseBall.Ball() == 0 && baseBall.Strike() == 0) {
            bw.write("Nothing\n");
        }
    }

    public void FinishView() throws IOException {
        bw.write("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요\n");
    }
}
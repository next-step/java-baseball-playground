package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Balls comBalls = computer.generator();
        List<Integer> userList = new ArrayList<>();

        while (true){
            Scanner input = new Scanner(System.in);

            System.out.print("세자리를 입력해주세요 : ");
            String line = input.next();

            if (!ValidationCheck.isThreeWord(line))
                throw new IllegalArgumentException("세자리의 숫자가 아닙니다.");

            String []splitNumber = line.split("");
            addUserList(userList, splitNumber);

            BaseBallReport report = comBalls.play(userList);
            System.out.println(report);
        }
    }
    private static void addUserList(List<Integer> userList, String[] splitNumber){
        for (int i=0; i<splitNumber.length; i++){
            userList.add(Integer.parseInt(splitNumber[i]));
        }
    }
}

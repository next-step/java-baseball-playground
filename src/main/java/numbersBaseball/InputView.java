package numbersBaseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class InputView {
    public static int[] check = new int[10]; // 1 ~ 9

    // 3자리 수 입력 받기
    public static int inputNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    // 랜덤 수 3자리 생성
    public static int duplicateCheck(int[] randomNum, int idx, int num) {
        if(check[num] == 0) {
            randomNum[idx] = num;
            check[num] = idx + 1; // random number 각 인덱스값 저장
            idx++;
        }
        return idx; //현재 idx 반환
    }
    public static void makeRandomNumber(int[] randomNum) {
        int idx = 0;

        while (idx != 3) {
            int cur = ((int)(Math.random()*8)+1); // random number 생성
            idx = duplicateCheck(randomNum, idx, cur);
        }
    }


    // validation
    public static boolean validateNumber(ArrayList<Integer> numList) {
        boolean verification = false;

        if(!(numList.size()==3)) return verification;
        for (Integer number: numList) {
            if(!(Collections.frequency(numList, number) == 1)) {
                System.out.println(ValidationError.duplication);
                return verification;
            }
            if(!((0 < number) && (number < 10))) {
                System.out.println(ValidationError.intermediateValue);
                return verification;
            }
        }

        return true;
    }

    // 정수 쪼개기
    public static ArrayList<Integer> splitNumber(int inputNum) {
//        int[] numList = new int[4];
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(inputNum / 100);
        arr.add((inputNum % 100) / 10);
        arr.add((inputNum % 10));

        return arr;
    }
}

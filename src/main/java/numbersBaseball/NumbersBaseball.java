package numbersBaseball;

import java.util.ArrayList;

public class NumbersBaseball {

    public static int compareTo(ArrayList<Integer> compareNum){
        // 초기화
        int strike = 0, ball = 0;

        for (int i = 1; i <= 3; i++) {
            int cur = compareNum.get(i-1);

            if(InputView.check[cur] != 0 && InputView.check[cur] == i) {
                strike++;
                continue;
            }
            if(InputView.check[cur] != 0) {
                ball++;
            }
        }
        System.out.println(ResultView.scoreResult(strike, ball));
        return strike;
    }

    public void game(int[] randomNum) {
        int strike = 0,  ball = 0;
        InputView.makeRandomNumber(randomNum);

        while(strike != 3) {
            System.out.print("숫자를 입력해 주세요 : ");

            int inputNum = InputView.inputNumber();
            ArrayList<Integer> inputList = InputView.splitNumber(inputNum);

            if(!InputView.validateNumber(inputList)) continue;

            strike = compareTo(inputList);
        }
    }

    public NumbersBaseball() {
        int[] randomNum = new int[3];
        while (true) {
            game(randomNum);
            ResultView.ending();
            if(InputView.inputNumber() == 2) return;
        }
    }

    public static void main(String[] args) {
        new NumbersBaseball();
    }
}

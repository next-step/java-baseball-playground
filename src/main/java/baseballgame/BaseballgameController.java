package baseballgame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballgameController {

    InputView view = new InputView();
    int[] randomNumber = new int[3];
    int[] inputNumber;

    int strike;
    int ball;

    /**
     * 숫자 야구 게임 시작
     * */
    public void baseballStart() {
        randomNumber = randomNumber(); //create random number
        userInputNumber();
    }

    /**
     * 숫자 야구 게임 사용자가 입력한값 비교하는 메서드
     * */
    public void userInputNumber() {
        strike = 0;
        ball = 0;

        inputNumber = view.inputNumber(); //input user number

        //inputNumber comfirm
        if(inputNumber.length > 3) {
            System.out.println("3자리 숫자만 입력이 가능합니다. 다시 입력해주세요");
            inputNumber = view.inputNumber();
        }

        //number compare
        for(int i = 0; i < inputNumber.length ; i++) {
            numberCompare(randomNumber, inputNumber[i] , i);
        }

        String answer = evaluateCondition();

        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart();
        }
        userInputNumber();
    }


    /**
     * 숫자 야구 게임 재시작 여부 메소드
     * */
    private void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        if(number.equals("1")) {
            baseballStart();
        }
        if(number.equals("2")) {
            System.exit(0);
        }
    }

    /**
     * 숫자야구 결과 확인용 메소드
     * */
    public String evaluateCondition() {
        if(strike > 0 && ball > 0 ) {
            return ball + "볼" + strike + "스트라이크";
        }
        if(strike == 0 && ball > 0) {
            return ball + "볼";
        }
        if(strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }
        if(strike == 3) {
            return "3스트라이크";
        }
        return "낫싱";
    }

    /**
     * 컴퓨터 랜덤 숫자와 사용자 입력 숫자 비교 메서드
     * */
    public void numberCompare(int[] randomNumber, int inputNumber, int i) {
        if(randomNumber[i] == inputNumber) { //숫자와 위치가 동일하다
            strike++;
            return;
        }
        if(randomNumber[1] == inputNumber || randomNumber[2] == inputNumber) { //숫자는 동일, 위치는 동일하지않음
            ball++;
        }
    }

    /**
     * 컴퓨터 세자리 숫자 랜덤 생성
     * */
    public int[] randomNumber() {
        Set<Integer> num = new HashSet<>();

        while (num.size() < 3){
            num.add((int) Math.ceil(Math.random() * 9));
        }

        int i = 0;
        for (int number : num) {
            randomNumber[i++] = number;
        }
        return randomNumber;
    }
}

package study.numberBaseball;

import java.util.Scanner;

public class NumberBaserball {


    public int initNumber() {

        int num = makeNumber();

        while(hasSameNumber(num)){
            num = makeNumber();
        }

        return num;

    }

    public boolean hasSameNumber(int num) {
        int[] nums = new int[3];
        int index = 0;
        while(num > 0){
            nums[index++] = num % 10;
            num /= 10;
        }

        return nums[0] == nums[1]
                || nums[1] == nums[2]
                || nums[2] == nums[0];
    }

    public int makeNumber() {
        return (int)(Math.random() * 1000);
    }

   public int scanNumber(Scanner sc) {

       System.out.print("숫자를 입력해 주세요 : ");
       return sc.nextInt();
   }

    public int countBall(int number, int input) {

        int[] numbers = numberToArray(number);
        int[] inputs = numberToArray(input);

        int count = 0;
        if(numbers[0] == inputs[1] || numbers[0] == inputs[2]){
            count += 1;
        }
        if(numbers[1] == inputs[2] || numbers[1] == inputs[0]){
            count += 1;
        }
        if(numbers[2] == inputs[0] || numbers[2] == inputs[1]){
            count += 1;
        }

        return count;
    }

    public int[] numberToArray(int number) {
        int[] result = new int[3];
        for(int i = 2 ; i >= 0 ; i--){
            result[i] = number % 10;
            number /= 10;
        }
        return result;
    }

    public int countStrike(int number, int input) {
        int[] numbers = numberToArray(number);
        int[] inputs = numberToArray(input);
        int count = 0;
        for(int i = 0 ; i < inputs.length ; i++){
            count += numbers[i] == inputs[i] ? 1 : 0;
        }
        return count;
    }

    public String printResult(int ballCount, int strikeCount) {

        StringBuilder sb = new StringBuilder();
        if(strikeCount == 3){
            sb.append("3스트라이크\n");
            sb.append("3개의 숫자를 모두 맞히셧습니다! 게임종료");

            return sb.toString();
        }


        if(ballCount > 0){
            sb.append(ballCount).append("볼");
        }
        if(ballCount > 0 && strikeCount > 0){
            sb.append(" ");
        }
        if(strikeCount > 0){
            sb.append(strikeCount).append("스트라이크");
        }
        if(ballCount == 0 && strikeCount == 0){
            sb.append("아무것도 없습니다.");
        }

        return sb.toString();

    }

    public int contiueGame(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextInt();
    }

    public void printGameOver() {
        System.out.println("게임종료!");
    }
}

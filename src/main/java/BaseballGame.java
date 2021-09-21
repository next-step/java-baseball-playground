import java.util.Random;
import java.util.Scanner;

import static java.lang.String.*;

public class BaseballGame {

    public int[] generateNumbers() {
        int digit = 3; // 3개 뽑을 것이고, 3번 반복할 횟수를 지정
        int[] numbers = new int[digit];

        int count = 0; // 배열의 인덱스 체크, 값이 들어갔을 때만 + 1 하게 된다.
        while (count != digit) {
            count = createRandomNums(numbers, count);
        }
        return numbers;
    }

    public int[] inputNumber() {
        Scanner sc = new Scanner(System.in);

        int digit = 3;
        int[] numbers = new int[3];

        System.out.println("숫자를 입력해 주세요!");
        String[] inputNumbers = sc.nextLine().split("");

        for (int i = 0; i < digit; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        return numbers;
    }

    public String compareUserToComputer(int[] userNumber, int[] computerNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < userNumber.length; i++) {
            strikeCount += compareStrike(userNumber[i], computerNumber[i]);
        }

        for (int i = 0; i < userNumber.length; i++) {
            ballCount += compareBall(userNumber[i], computerNumber, i);
        }
        return write(strikeCount, ballCount);
    }

    public int compareStrike(int user, int computer) {
        if (user == computer) {
            return 1;
        }
        return 0;
    }

    public int compareBall(int user, int[] computer, int index) {
        int count = 0;
        for (int i = 0; i < computer.length; i++) {
            if (i != index && user == computer[i]) {
                count++;
            }
        }
        return count;
    }

    public String write(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "nothing";
        }
        return format("%d strike / %d ball", strike, ball);
    }

    public boolean duplicateCheck(int[] numbers, int num) {
        for (int number : numbers) {
            if (number == num) {
                return false;
            }
        }
        return true;
    }

    public int createRandomNums(int[] numbers, int count) {
        Random random = new Random();

        int num = random.nextInt(9) + 1;
        if (duplicateCheck(numbers, num)) {
            numbers[count] = num;
            count++;
        }
        return count;
    }
}

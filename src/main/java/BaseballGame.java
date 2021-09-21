import java.util.Random;

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

    private boolean duplicateCheck(int[] numbers, int num) {
        for (int number : numbers) {
            if (number == num) {
                return false;
            }
        }
        return true;
    }

    private int createRandomNums(int[] numbers, int count) {
        Random random = new Random();

        int num = random.nextInt(9) + 1;
        if (duplicateCheck(numbers, num)) {
            numbers[count] = num;
            count++;
        }

        return count;
    }
}

package PlusCalculator;

public class PlusCalculator {
    public static int calculate(String[] numbers) {
        if(numbers.length == 1) {
            return Integer.valueOf(numbers[0]);
        }
        return plus(numbers);
    }

    private static int plus(String[] results) {
        int sum = 0;
        for(int i  = 0; i < results.length; i++) {
            sum += Integer.valueOf(results[i]);
        }
        return sum;
    }
}

public class RandomNumber {
    private static int[] numberArray = new int[9];
    public static int[] computerNumbers = new int[3];
    public static int[] arrayFill() {
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i + 1;
        }
        return numberArray;
    }

    public static int[] shuffleArray() {
        int tmp;
        arrayFill();
        for (int i = 0; i < numberArray.length; i++) {
            int j = (int) (Math.random() * 9);
            tmp = numberArray[j];
            numberArray[j] = numberArray[i];
            numberArray[i] = tmp;
        }
        return numberArray;
    }

    public static int[] selectNumbers() {
        shuffleArray();
        System.arraycopy(numberArray, 0, computerNumbers, 0, computerNumbers.length);
        return computerNumbers;
    }


}

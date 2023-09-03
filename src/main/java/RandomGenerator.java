import java.util.Random;

public class RandomGenerator {
    public void createRandomNums() {
        Random rd = new Random();
        int randomNum = rd.nextInt(9)+1;
    }
}

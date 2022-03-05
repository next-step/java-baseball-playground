package NumberBaseballGame;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ComputerNumber {
    private List<Integer> computerNumbers;

    public void makeNumbers() {
        Random random = new Random();
        Set<Integer> numberSet = new LinkedHashSet<>();
        while(numberSet.size() <= 3) {
            numberSet.add(random.nextInt(8) + 1);
        }
        computerNumbers = new ArrayList<>(numberSet);
    }

    public List<Integer> getComputerNumbers() { return computerNumbers; }
}

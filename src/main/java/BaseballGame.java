import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class BaseballGame {

     InputService inputService;
     Round round;
     ArrayList<Integer> solution;

     
     public BaseballGame(InputService inputService) {
          this.inputService = inputService;
     }
     
     void start() throws IOException {
          setSolution();
          ArrayList inputs = inputService.startConsole();
          round = new Round(solution, inputs);
          System.out.println(round.getBall());
          System.out.println(round.getStrike());;
          System.out.println(round.isOut());
     }

     void setSolution() {
          Random random = new Random();
          LinkedHashSet<Integer> checkDuplication = new LinkedHashSet<>();

          while(checkDuplication.size()<3) {
               int tmpNum = random.nextInt(8)+1;
               System.out.println(tmpNum);
               checkDuplication.add(tmpNum);
          }
          solution = new ArrayList<>(checkDuplication);
     }

     public ArrayList<Integer> getSolution() {
          return solution;
     }
}

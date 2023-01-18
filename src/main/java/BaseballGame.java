import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

public class BaseballGame {

     InputService inputService;
     ResultView resultView;
     Round round;
     ArrayList<Integer> solution;
     boolean isRight = false;
     boolean isEnd = false;

     
     void start() throws IOException {
          setSolution();
          while(!isRight) {
               inputService = new InputService();
               ArrayList inputs = inputService.startConsole();
               round = new Round(solution, inputs);
               resultView = new ResultView(round);
               resultView.printResult();
               isRight = resultView.setRight();
          }
          setEnd();
          if(isEnd) {
               BaseballGame newGame = new BaseballGame();
               newGame.start();
          }
     }

     void setEnd() throws IOException{
          int restartNum = inputService.checkRestart();
          if(restartNum==1)
               isEnd=true;
          if(restartNum==2)
               System.out.println("게임 종료!");
     }


     void setSolution() {
          Random random = new Random();
          LinkedHashSet<Integer> checkDuplication = new LinkedHashSet<>();

          while(checkDuplication.size()<3) {
               int tmpNum = random.nextInt(8)+1;
               checkDuplication.add(tmpNum);
          }
          solution = new ArrayList<>(checkDuplication);
          System.out.println(solution.toString());
     }

     public ArrayList<Integer> getSolution() {
          return solution;
     }
}

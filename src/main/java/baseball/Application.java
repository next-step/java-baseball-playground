package baseball;

public class Application {


    public void run(){
        Balls answerBalls = new Balls(RandomNumberCreator.makeNumbers());
        User user = new User();
        boolean runStatus = true;
        while(runStatus){
            String input = user.getInput();
            Balls userBalls = new Balls(input);
            runStatus = !Referee.judgement(answerBalls, userBalls);
        }
        if(restart()){
            run();
        }

    }
    private boolean restart(){
        User user = new User();
        String decision = user.askRestart();
        if(decision.equals("1")){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Application computer = new Application();
        computer.run();
    }
}

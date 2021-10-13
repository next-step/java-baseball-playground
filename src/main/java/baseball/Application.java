package baseball;

public class Application {
    private Balls makeUserBall(){
        User user = new User();
        Balls userBalls;
        try {
            String input = user.getInput();
            userBalls = new Balls(input);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            userBalls = makeUserBall();
        }
        return userBalls;
    }

    public void run(){
        Balls answerBalls = new Balls(RandomNumberCreator.makeNumbers());
        boolean runStatus = true;
        while(runStatus){
            Balls userBalls = makeUserBall();
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

package baseball;

import java.util.List;

public class Application{
    public static void main(String[] args) {
        Application com = new Application();
        com.run();
    }

    public void run(){

        boolean gameStatus = true;
        Balls computer = new Balls(RandomNumber.makeFullRandomNumber());
        User user = new User();
        System.out.println("게임이 시작되었습니다.");
        while(gameStatus){
            gameStatus = playGame(computer,user);
        }

        if(user.restartGame()){
            run();
        }


    }

    public boolean playGame(Balls computer,User user){
        Balls input = user.makeInput();
        List<Integer> result =  Balls.validate(computer, input );

        int strike = result.get(0);
        int ball = result.get(1);

        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike!=0 && ball==0){
            System.out.println(result.get(0)+"스트라이크");
        }
        if(strike==0 && ball!=0){
            System.out.println(result.get(1) + "볼");
        }
        if(strike!=0 && ball!=0){
            System.out.println(result.get(0)+"스트라이크 "+result.get(1) + "볼");
        }
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.");
            return false;
        }

        return true;
    }

}

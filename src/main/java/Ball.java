import java.util.List;

public class Ball {

    public static int getBall(final List<String> randomNumber, final List<String> number){

        int ball = 0;

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(randomNumber.get(i).equals(number.get(j))){
                    if(i == j){
                        ball++;
                    }
                }
            }
        }

        return ball;

    }
}

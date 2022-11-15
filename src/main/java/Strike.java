import java.util.List;

public class Strike {

    public static int getStrike(final List<String> randomNumber, final List<String> number){

        int strike = 0;

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(randomNumber.get(i).equals(number.get(j))){
                    if(i == j){
                        strike++;
                    }
                }
            }
        }

        return strike;

    }
}

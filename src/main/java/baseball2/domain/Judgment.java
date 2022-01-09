package baseball2.domain;

import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> computer , List<Integer> player){
        int result = 0;
        for(int i =0; i<player.size(); i++){
            if(computer.contains(player.get(i))){
                result ++;
            }
        }
        return result;
    }

    public boolean hasPlace(List<Integer> computer , int placeIndex , int number){
        return computer.get(placeIndex) == number;
    }
}

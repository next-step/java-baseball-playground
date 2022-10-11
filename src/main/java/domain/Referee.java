package domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player ){
        Judgment judgment = new Judgment();
        int correctCount = judgment.correctCount(computer, player);
        int strike =0;
        for(int placeIndex = 0; placeIndex<player.size(); placeIndex++){
            if(judgment.hasPlace(computer,placeIndex,player.get(placeIndex))){
                strike++;
            }
        }
        int ball = correctCount-strike;

        if(correctCount==0){
            return "낫싱";
        }
        return ball +"볼"+strike+"스트라이크";
    }
}

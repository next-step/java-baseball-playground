package baseballgame;

import java.util.List;

public class Compare {
    public int count(List<Integer> computer, List<Integer> player) {
        int count = 0;

        for(int i = 0; i < player.size(); i++) {
            if(computer.contains(player.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int Strikecount(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for(int i = 0; i < player.size(); i++) {
            if(computer.get(i) == player.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public String Compare_num(List<Integer> computer, List<Integer> player) {
        int count = count(computer, player);
        int strike = Strikecount(computer, player);
        int ball = count - strike;

        if(count == 0) return "nothing";
        else if(strike == 0) return ball + "ball";
        else if(ball == 0) return strike + "strike";
        else return ball + "ball " + strike + "strike";
    }
}

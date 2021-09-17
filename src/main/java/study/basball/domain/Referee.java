package study.basball.domain;

import java.util.HashSet;
import java.util.List;

public class Referee {

    public static String compare(HashSet<Integer> computer, List<Integer> player) {
        Judgement judgement = new Judgement();

        int currectCount = judgement.currectCount(computer, player).size();
        int containsNumbers = judgement.hasPlace(computer, player).size();
//        System.out.println("currectCount" + currectCount);
//        System.out.println("containsNumbers" + containsNumbers);
        
        if (currectCount == 3) {
            return "3 스트라이크";
        } else if (currectCount == 2) {
            return "2 스트라이크";
        } else if (containsNumbers == 2) {
            return "2볼";
        } else if (containsNumbers == 1) {
            return "1볼";
        } else if (containsNumbers == 2 && currectCount == 1) {
            return "2볼 1스트라이크";
        } else if (containsNumbers == 1 && currectCount == 1) {
            return "1볼 1스트라이크";
        } else {
            return "1스트라이크";
        }
    }

}

package baseballgame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Judgement {
    public int isContainNumber(ArrayList computer, ArrayList user) {
        int count = 0;
        for (int index = 0; index < user.size(); index++) {
            int userNum = (int)user.get(index);
            if(computer.contains(userNum)) {
                count++;
            }
        }
        return count;
    }

    public boolean isCheckNumber(ArrayList computer, int index , int userNum) {
        return (int)computer.get(index) == userNum;
    }
}

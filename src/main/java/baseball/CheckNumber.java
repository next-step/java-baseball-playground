package baseball;

import java.util.List;

public class CheckNumber {
    public int checkNumber(List<Integer> computerNumberList, int[] userNumber) {
        int result = 0;
        for(int i=0;i<userNumber.length;i++){
            result += isCorrect(computerNumberList,userNumber[i],i);
        }
        return result;
    }
    public int isCorrect(List<Integer> computerNumberList,int userNumber,int index) {
        if(!computerNumberList.contains(userNumber)){
            return 0;
        }
        if(computerNumberList.indexOf(userNumber) == index) {
            return 10;
        }
        if(computerNumberList.indexOf(userNumber) != index) {
            return 1;
        }
        return 0;
    }

}

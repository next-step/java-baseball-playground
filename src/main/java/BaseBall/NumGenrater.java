package BaseBall;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumGenrater {

    public List<Integer> numGenerater(){
        Random r = new Random();
        List<Integer> ComNumber = new ArrayList<>();
        while(ComNumber.size()<3){
            int num = r.nextInt(9) + 1;
            if(ComNumber.contains(num)) continue;
            else ComNumber.add(num);
        }

            return ComNumber;
    }
}

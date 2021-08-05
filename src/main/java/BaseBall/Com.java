package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class Com {

    public int[] Com(){
        int[] Com=new int[3];
        Random r = new Random();
        while (Com[0]==0){
            Com[0]=r.nextInt(10);
        }
        while (Com[0]==Com[1]||Com[1]==0){
            Com[1]=r.nextInt(10);
        }
        while (Com[1]==Com[2]||Com[2]==0){
            Com[2]=r.nextInt(10);
        }
        return Com;
    }

}

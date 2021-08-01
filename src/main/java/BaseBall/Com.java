package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class Com {

    public ArrayList<Integer> ComGenerate(){
        ArrayList<Integer> Com=new ArrayList<>();
        Random r = new Random();
        while (Com.indexOf(0)==0){
            Com.add(0,r.nextInt(10));
        }
        while (Com.get(0)==Com.get(1)||Com.get(1)==0){
            Com.add(1,r.nextInt(10));
        }
        while (Com.get(1)==Com.get(2)||Com.get(2)==0){
            Com.add(2,r.nextInt(10));
        }
        return Com;
    }

}

package BaseBall;

import java.util.ArrayList;

public class Referee {

    static int SIZE=3;

    public int Strike(int[] a, int[] b){
        int strike=0;
        for (int i = 0; i <SIZE ; i++) {
            if(a[i]==b[i]) strike++;
        }
        return strike;
    }

    public int Ball(int[] a,int[] b){
        int ball=0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(a[i]==b[j]&&i!=j) ball++;

            }
        }
            return ball;
    }

    public StringBuilder check(int a, int b){
        StringBuilder sb=new StringBuilder();
        if(a==3){
            sb.append("3스트라이크");
        }else if(b==0&&a!=0){
            sb.append(a + "스트라이크");
        }else if(b!=0&&a!=0){
            sb.append(b + "볼 " + a + "스트라이크");
        }else if(b!=0&&a==0){
            sb.append(b + "볼");
        }
        return sb;
    }



}

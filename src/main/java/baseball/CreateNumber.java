package baseball;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class CreateNumber {
    public static void baseball(){
        int strike = 0;
        int ball = 0;
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        while(hashSet.size()<3){
        int ran = random.nextInt(9+1);
            hashSet.add(ran);
        }
//        HashSet에 들어간 element를 확인하고 싶을 떄
        System.out.println(hashSet);

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String num = sc.nextLine();

        Iterator<Integer> ir = hashSet.iterator();
        while(ir.hasNext()){
            int number = ir.next();

        }



//        for(int i =0; i<number.length(); i++){
//
//            if(hashSet.equals(number.charAt(i)))
//                strike++;
//            else if (hashSet.contains(number.charAt(i))) {
//                ball++;
//            }
////           {ball or strike}
////            Strirng number의 charAt() == HaseSet의 요소와 비교필요
////            즉 경우를 나눠야하지 않을까? 줄이 길어지면 depth가 깊어진다.
//        }
        System.out.println("스트라이크 : "+strike);
        System.out.println("볼 : "+ball);
    }
}

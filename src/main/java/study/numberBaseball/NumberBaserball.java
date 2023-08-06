package study.numberBaseball;

import java.util.Scanner;

public class NumberBaserball {

    int[] number;
    int[] input;

    public NumberBaserball(){
        number = initNumber();
    }

    public int[] initNumber() {

        int[] num = makeNumber();

        while(hasSameNumber(num)){
            num = makeNumber();
        }

        return num;

    }

    public boolean hasSameNumber(int[] num) {

        return num[0] == num[1]
                || num[1] == num[2]
                || num[2] == num[0];
    }

    public int[] makeNumber() {

        int[] num = new int[3];

        for(int i = 0 ; i < 3 ; i++){
            num[i] = (int)(Math.random() * 10);
        }

        return num;
    }

   public void scanNumber() {
       Scanner sc = new Scanner(System.in);
       int num = sc.nextInt();

       int[] result = new int[3];
       int i = 2;
       while (num > 0) {
           result[i--] = num % 10;
           num /= 10;
       }
       this.input = result;
   }

   public String guessTheAnswer(){

        int



   }

}

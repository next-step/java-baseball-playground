package study.baseballgame;

import java.io.IOException;

public class BaseballGame  {

    //상속 안됨
    private final int[] randomNumber = new int[3];

    private BaseballGame() throws IOException{
            makeNanSu();
    }

    // 게임이 시작되고 나면 입력값을 받아야한다.
    public static BaseballGame start() throws IOException {
        return new BaseballGame();
    }

    private void makeNanSu(){
        for ( int i = 0 ; i < randomNumber.length; i++){

            randomNumber[i] = (int) Math.abs(Math.random() * 9 + 1);

            if(i != 0 && randomNumber[i] == randomNumber[i-1] || i == 2 && randomNumber[0] == randomNumber[2]){
                i--;
            }
        }
    }

    // 받은 입력값을 필터링
    // 조건 1. 숫자의 조합이 맞는가? -- 정규식
    // 조건 2. 0이 포함되어 있는가? -- 그냥 0 체크
    public boolean valid(String num) throws IllegalArgumentException{

        if(num.length() != 3){

           throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
        if(num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2)){

            throw new IllegalArgumentException("서로 다른 숫자들을 입력하세요.");
        }

        if(!num.matches("[1-9]+")){

            //throw new IllegalArgumentException(NamingTest.ONETONINE.getName());
        }

        return true;
    }



    public int checkStrikeAndBall(String num){

        char[] gettingNumber = new char[3];
        for (int i = 0 ; i < 3; i++){
            gettingNumber[i] = num.charAt(i);
        }


       int strike = 0 ;
       int ball = 0;

       for ( int i = 0 ; i < randomNumber.length; i++){
            if (randomNumber[i] == Character.getNumericValue(gettingNumber[i])){
              strike++;
            }
            ball += checkBall(i, gettingNumber);
       }

       if(strike ==3){
           System.out.println("홈런입니다.");
       }

        System.out.println("ball = " + ball + " " + "strike = " + strike);

       return strike;
    }

    private int checkBall(int j,char[] gettingNumber){
        int ball = 0;
        for( int i = 0; i < randomNumber.length; i++){
            if(j == i){
                continue;
            }

            if(randomNumber[j] == Character.getNumericValue(gettingNumber[i])){
                ball++;
            }
        }
        return ball;
    }

}

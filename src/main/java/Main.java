import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        while(true){

            String answer = getAnswer();

            while (true){
                Scanner in = new Scanner(System.in);

                System.out.print("숫자를 입력해 주세요 : ");
                String number = in.nextLine();

                if(number.equals(answer)){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("정답은 : " + answer);
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                    int num = in.nextInt();
                    if(num == 1){
                        break;
                    }else{
                        return;
                    }
                }
                int ball = 0;
                int strike = 0;
                for(int i = 0;i<3;i++){
                    for(int j = 0;j<3;j++){
                        if(answer.charAt(i) == number.charAt(j)){
                            if(i == j){
                                strike++;
                                break;
                            }
                            else{
                                ball++;
                            }
                        }
                    }
                }
                if(ball + strike == 0){
                    System.out.println("Four Ball or Nothing");
                }
                System.out.println(ball +" 볼 " + strike +"스트라이크");
            }
        }
    }

    private static String getAnswer() {

        Random rand = new Random();

        String answer = "";

        while(true){
            final HashSet<Integer> three = new HashSet<>();
            for(int i = 0;i<3;i++){
                final int randomNumber = rand.nextInt(9) + 1;
                three.add(randomNumber);
            }
            if(three.size() == 3){
                answer = makeAnswer(three);
                break;
            }
        }
        return answer;
    }

    private static String makeAnswer(final HashSet<Integer> three) {
        String answer = "";

        for(Integer num : three){
            answer += num;
        }

        return answer;
    }
}

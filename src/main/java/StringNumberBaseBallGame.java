import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringNumberBaseBallGame {

    public static void main(String[] args) {

        Random random = new Random();
        String[] randomNumber = new String[3];

        // 스트라이크 수 초기화
        int strikeCnt = 0;
        // 볼 수 초기화
        int ballCnt = 0;

        // 3자리 난수 생성 (int 값을 String으로 형변환)
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = Integer.toString(random.nextInt(9));
        }
        randomNumber[0] = "1";
        randomNumber[1] = "1";
        randomNumber[2] = "2";

        System.out.println("난수 값 : " + Arrays.toString(randomNumber));
        // 사용자가 입력한 숫자
        String baseBallNumber = "";

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요. : ");

        baseBallNumber = scanner.nextLine();

        // 입력받은 숫자를 String배열로 저장
        String[] baseBallNumberArray = baseBallNumber.split("");

        for (int i = 0; i < randomNumber.length; i++){

            strikeCnt = _getStrikeCnt(strikeCnt, randomNumber[i], baseBallNumberArray[i]);

            ballCnt = _getballCnt( ballCnt,  i, randomNumber[i], baseBallNumberArray );
        }

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
            return;
        }

        System.out.println("스트라이크 : " + strikeCnt);
        System.out.println("볼 : " + ballCnt);
    }

    static int _getStrikeCnt(int strikeCnt, String randomNumber, String baseBallNumberArray) {

        if (randomNumber.equals(baseBallNumberArray)) {
            strikeCnt++;
        }
        return strikeCnt;
    }

    static int _getballCnt(int ballCnt, int index, String randomNumber, String[]baseBallNumberArray) {

        for (int j = 0; j < baseBallNumberArray.length; j++){
            ballCnt = _getLoop(ballCnt, index, j, randomNumber, baseBallNumberArray[j]);
//            System.out.println("볼 cnt 값 확인 : " + ballCnt);
        }

        return ballCnt;
    }

    static int _getLoop(int ballCnt, int index1, int index2, String randomNumber, String baseBallNumberArray) {

//        System.out.println("_getLoop index1 확인 : " + index1);
//        System.out.println("_getLoop index2 확인 : " + index2);
        if (index1 != index2 && randomNumber.equals(baseBallNumberArray)){
            ballCnt++;
//            System.out.println("_getLoop 볼 cnt 값 확인 : " + ballCnt);
        }
        return ballCnt;
    }
}

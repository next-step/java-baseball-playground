import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private static int SIZE = 3;

    /**
     * 시작
     */
    public void init() {

        //1. 난수 생성
        LinkedHashSet<Integer> randomNums = makeRandomNumbers();
        boolean flag = false;
        while(!flag) {
            //2. 사용자 숫자 입력
            String numString = _getInputNumString();

            //3. 정답 확인
            flag = tryAnswer(numString, randomNums);
        }

        //4. 재시작 입력
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String restartFlag = scanner.nextLine();

        if (restartFlag.equals("1")) init();
    }

    /**
     * 난수 생성
     * @return
     */
    public LinkedHashSet<Integer> makeRandomNumbers() {
        LinkedHashSet<Integer> randomNums = new LinkedHashSet<>();
        Random rd = new Random();
        while (randomNums.size()<SIZE) {
            randomNums.add(rd.nextInt(9));
        }
        return randomNums;
    }

    /**
     * 정답 시도
     * @param numString
     * @param randomNums
     * @return
     */
    public boolean tryAnswer(String numString, LinkedHashSet<Integer> randomNums) {

        //1. ball,strike Counter
        HashMap<String, Integer> counter = _initCounter();

        for (int i=0; i<numString.length(); i++) {
            //2. 사용자 숫자 한글자씩 자름
            Integer num = Integer.parseInt(numString.substring(i,i+1));

            //3. ball or strike 판별
            countBallOrStrike(counter, randomNums, num, i);
        }

        //4. count 결과 출력
        _printResult(counter);

        //5. 정답 여부
        return counter.get("strike") == SIZE;
    }

    /**
     * 사용자 숫자 입력
     * @return
     */
    private String _getInputNumString() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        return numString;
    }

    /**
     * ball or strike 판별
     * @param counter
     * @param randomNums
     * @param num
     * @param index
     */
    public void countBallOrStrike(HashMap<String, Integer> counter, LinkedHashSet<Integer> randomNums, Integer num, int index) {
        Integer[] randomNumArray = randomNums.toArray(new Integer[randomNums.size()]);
        if (randomNumArray[index] == num) {
            counter.put("strike",counter.get("strike")+1);
            return;
        }
        if (randomNums.contains(num)) {
            counter.put("ball", counter.get("ball")+1);
        }
    }

    /**
     * 결과 출력
     * @param count
     */
    private void _printResult(HashMap<String, Integer> count) {
        if(count.get("ball") > 0) {
            System.out.print(count.get("ball")+"볼 ");
        }

        if(count.get("strike") > 0) {
            System.out.print(count.get("strike")+"스트라이크");
        }
        System.out.println();
    }

    /**
     * Counter 초기화
     * @return
     */
    private HashMap<String, Integer> _initCounter() {
        HashMap<String, Integer> counter = new HashMap<>();
        counter.put("ball", 0);
        counter.put("strike", 0);

        return counter;
    }


}



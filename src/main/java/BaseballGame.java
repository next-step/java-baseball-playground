import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    private static int SIZE = 3;

    public void init() {
        LinkedHashSet<Integer> randomNums = makeRandomNumbers();
        boolean flag = false;
        while(!flag) {
            String numString = _getInputNumString();
            flag = tryAnswer(numString, randomNums);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String restartFlag = scanner.nextLine();

        if (restartFlag.equals("1")) init();
    }

    public LinkedHashSet<Integer> makeRandomNumbers() {
        LinkedHashSet<Integer> randomNums = new LinkedHashSet<>();
        Random rd = new Random();
        while (randomNums.size()<SIZE) {
            randomNums.add(rd.nextInt(9));
        }
        return randomNums;
    }

    public boolean tryAnswer(String numString, LinkedHashSet<Integer> randomNums) {

        HashMap<String, Integer> count = new HashMap<>();
        count.put("ball", 0);
        count.put("strike", 0);

        for (int i=0; i<numString.length(); i++) {
            Integer num = Integer.parseInt(numString.substring(i,i+1));
            _countBallOrStrike(count, randomNums, num, i);
        }

        _printResult(count);

        return count.get("strike") == SIZE;
    }

    private String _getInputNumString() {
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        return numString;
    }

    private void _countBallOrStrike(HashMap<String, Integer> count, LinkedHashSet<Integer> randomNums, Integer num, int index) {
        Integer[] randomNumArray = randomNums.toArray(new Integer[randomNums.size()]);
        if (randomNumArray[index] == num) {
            count.put("strike",count.get("strike")+1);
            return;
        }
        if (randomNums.contains(num)) {
            count.put("ball", count.get("ball")+1);
        }
    }

    private void _printResult(HashMap<String, Integer> count) {
        if(count.get("ball") > 0) {
            System.out.print(count.get("ball")+"볼 ");
        }

        if(count.get("strike") > 0) {
            System.out.print(count.get("strike")+"스트라이크");
        }
        System.out.println();
    }


}



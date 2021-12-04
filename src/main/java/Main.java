import comparenumbers.CompareNumbers;
import createrandom.CreateRandomThreeDigits;
import referee.RefereeCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CreateRandomThreeDigits createRandomThreeDigits = new CreateRandomThreeDigits();
        RefereeCheck refereeCheck = new RefereeCheck();
        CompareNumbers compareNumbers = new CompareNumbers();

        ArrayList<Integer> comList = createRandomThreeDigits.randomNumbers();

        String result = "";

        while (!result.equals("3스트라이크 0볼")) {

            ArrayList<Integer> userList = getIntegers();

            result = checkNumberThreeDigits(createRandomThreeDigits, refereeCheck, compareNumbers, comList, userList);

            gameResult(result);
        }
    }

    private static void gameResult(String result) {
        if (result.equals("3스트라이크 0볼")) {

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static String checkNumberThreeDigits
            (CreateRandomThreeDigits createRandomThreeDigits,
             RefereeCheck refereeCheck, CompareNumbers compareNumbers,
             ArrayList<Integer> comList, ArrayList<Integer> userList) {

        while (!createRandomThreeDigits.checkThreeDigits(userList)) {
            System.out.println("3자리 숫자가 아닙니다. 다시 입력해주세요.");
            userList = getIntegers();
        }

        compareNumbers.checkNumbers(comList, userList);
        String result = refereeCheck.strikeBallNumber(comList, userList);
        System.out.println(result);
        return result;
    }

    private static ArrayList<Integer> getIntegers() {
        System.out.print("숫자를 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String userNumbers = scanner.next();
        ArrayList<Integer> userList = new ArrayList<>();

        for (String number : userNumbers.split("")) {
            userList.add(Integer.parseInt(number));
        }
        return userList;
    }
}

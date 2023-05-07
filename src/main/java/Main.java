import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력해주세요: ");
        StringCalc stringCalc = new StringCalc(new Formula(scanner.nextLine()));

        int calcNumber = stringCalc.calc();

        System.out.println(String.format("연산된 값은 %d입니다.", calcNumber));
    }
}

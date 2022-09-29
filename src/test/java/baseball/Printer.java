package baseball;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Printer {
    private static Scanner scanner;
    private static PrintStream printStream;

    public Printer(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.printStream = printStream;
    }

    public String getInput(String str){
        printStream.println(str);
        return scanner.nextLine();
    }

    public static void print(String str){
        printStream.println(str);
    }

    public static void printResult(boolean win){
        print("-------------------------------");
        if (win) print("축하합니다! 모든 숫자를 맞추셨습니다.");
        if (!win){
            print("10라운드 안에 숫자를 맞추지 못했습니다.");
        }
        print("-------------------------------");
        System.exit(0);
    }

    public static void printRoundResult(int[] randoms, int round){
        int strike = 0;
        int ball = 0;
        int[] answers = printRound(round);

        for (int i = 0; i < answers.length; i++){

            for (int ran : randoms) {
                if (ran == answers[i]) ball += 1;
            }

            if (randoms[i] == answers[i]){
                strike += 1;
                ball -= 1;
            }

            if (strike == 3){
                printResult(true);
                break;
            }
        }

        print("\n"+ball+" 볼 "+strike+" 스트라이크");
    }

    public static int[] printRound(int round){
        printStream.println(round+"회차) 숫자를 입력해주세요 :");
        String answer = scanner.nextLine();

        try {
            Integer.parseInt(answer);
            Parser parser = new Parser();
            int[] answers = parser.stringToInts(answer);
            return answers;

        }catch (Exception e){
            print("입력오류입니다. 정수 숫자 세글자를 입력해주세요.");
            return printRound(round);
        }
    }

}

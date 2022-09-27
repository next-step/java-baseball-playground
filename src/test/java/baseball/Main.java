package baseball;

public class Main {

    private static String INTRO =
            "\n--------------------------\n"
            +"         숫자 야구게임\n"
            +"--------------------------\n";

    public static void main(String[] args){
        Printer printer = new Printer(System.in, System.out);
        printer.print(INTRO);

        int[] randoms = GetRandom.getRandoms();

        int round = 0;
        while (round<11){
            round++;
            Printer.printRoundResult(randoms, round);
            if (round == 10) Printer.printResult(false);
        }
    }
}

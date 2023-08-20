package utils;

public class RunGame {
    public static void main(String[] args){
        boolean run = true;
        BullsAndCows.gameStart();
        game.printResult();

        while(game.run) {
            game.progressGameRound(inputValue);
        }

        String inputOption = scanner.nextLine();
        validateGameProgressOptions(inputOption);
        int option = Integer.parseInt(inputOption);
        if(option == 1) {
            game.run = true;
            gameStart();
        }
    }
}

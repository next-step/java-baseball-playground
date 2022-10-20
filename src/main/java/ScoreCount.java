public class ScoreCount {
    int strike = 0;
    int ball = 0;
    private String number;

    ScoreCount(String input) {
        for (int i = 0; i < RandomNumber.computerNumbers.length; i++) {
            number = Integer.toString(RandomNumber.computerNumbers[i]);
            ballCount(input);
            strikeCount(input, i);
        }
        System.out.printf("%d볼 %d스트라이크%n", ball, strike);

    }

    public void win() {
        if (strike == 3) {
            GameWin.gameWin();
        }
    }

    public void ballCount(String input) {
        if (input.contains(number)) {
            ball++;
        }
    }

    public void strikeCount(String input, int i) {
        if (ball != 0 && input.indexOf(number) == i) {
            strike++;
            ball--;
        }
    }

}

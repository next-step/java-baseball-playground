import java.util.List;

public class Strike {

    public int getStrike(final List<String> randomNumber, final List<String> number) {

        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumber.get(i).equals(number.get(i))) {
                strike++;
            }
        }

        return strike;

    }
}

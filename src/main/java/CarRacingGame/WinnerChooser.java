package CarRacingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WinnerChooser {
    public static List<Car> chooseWinner(List<Car> cars) {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if(car1.getPosition() > car2.getPosition())
                {
                    return -1;
                }
                if(car1.getPosition() == car2.getPosition())
                {
                    return 0;
                }
                return 1;
            }
        });
        List<Car> winnerCars = new ArrayList<>();
        winnerCars.add(cars.get(0));
        for(int i = 1; i < cars.size(); i++) {
            if(cars.get(i).getPosition() == cars.get(0).getPosition()) {
                winnerCars.add(cars.get(i));
            }
        }
        return winnerCars;
    }
}

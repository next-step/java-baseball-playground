package racing.console;

import racing.core.Car;
import racing.core.CrazyDriver;
import racing.core.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<Car> getCars(String message) {
        System.out.println(message);
        String line = this.scanner.nextLine();
        String[] names = line.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, new CrazyDriver()));
        }

        return cars;
    }

    @Override
    public int getTrackLength(String message) {
        System.out.println(message);
        String line = this.scanner.nextLine();

        int trackLength = Integer.parseInt(line);

        return trackLength;
    }
}

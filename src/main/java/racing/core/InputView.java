package racing.core;

import java.util.List;

public interface InputView {
    List<Car> getCars(String message);

    int getTrackLength(String message);
}

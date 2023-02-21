package racing.core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String ENTER_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_TRACK_LENGTH_MESSAGE = "시도할 회수는 몇회인가요?";
    private final InputView inputView;
    private final OutputView outputView;
    private final List<Car> cars;
    private final int trackLength;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

        this.cars = inputView.getCars(ENTER_CAR_MESSAGE);
        this.trackLength = inputView.getTrackLength(ENTER_TRACK_LENGTH_MESSAGE);
    }

    public void play() {
        this.outputView.println("실행 결과");
        for (int i = 0; i < this.trackLength; i++) {
            for (Car car : this.cars) {
                car.move();
            }
            for (Car car : this.cars) {
                this.outputView.println(car.toString());
            }
            this.outputView.println("");
        }


        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : this.cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        for (Car car : this.cars) {
            if (car.positionedAt(maxPosition)) {
                winners.add(car.getName());
            }
        }

        this.outputView.println(String.join(", ", winners) + "가 최종 우승했습니다.");
        this.outputView.flush();
    }

}

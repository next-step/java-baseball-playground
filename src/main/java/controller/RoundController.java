package controller;

import domain.Balls;
import domain.Round;
import dto.RoundInputDto;
import dto.RoundOutputDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.RandomUtils.generateRandomNumber;
import static view.RoundOutputView.roundOutput;
import static view.RoundInputView.roundUserInput;
import static view.RoundOutputView.roundOverOutput;

public class RoundController {

    public static final int BASEBALL_LENGTH = 3;

    private Round round;

    private RoundController(Round round) {
        this.round = round;
    }

    public static RoundController getInstance() {
        List<Integer> numbers = initializeRandomBalls();
        Balls balls = Balls.from(numbers);
        Round round = Round.from(balls);
        return new RoundController(round);
    }

    private static List<Integer> initializeRandomBalls() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < BASEBALL_LENGTH) {
            int systemNumber = generateRandomNumber(1, 9);
            set.add(systemNumber);
        }
        return new ArrayList<>(set);
    }

    public void run() {
        while (!round.isOver()) {
            RoundInputDto roundInputDto = roundUserInput();
            List<Integer> userNumbers = roundInputDto.numbers();
            Balls userBalls = Balls.from(userNumbers);
            RoundOutputDto roundOutputDto = round.countResult(userBalls);
            roundOutput(roundOutputDto);
        }
        roundOverOutput();
    }
}

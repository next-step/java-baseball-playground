package controller;

import domain.Balls;
import domain.Generation;
import domain.Round;
import dto.RoundInputDto;
import dto.RoundOutputDto;
import view.RoundInputView;
import view.RoundOutputView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RoundController {

    public static final int BASEBALL_LENGTH = 3;

    private final RoundInputView roundInputView;
    private final RoundOutputView roundOutputView;
    private final Generation generation;


    private RoundController(final RoundInputView roundInputView, final RoundOutputView roundOutputView,
                            final Generation generation) {
        this.roundInputView = roundInputView;
        this.roundOutputView = roundOutputView;
        this.generation = generation;
    }

    public static RoundController of(final RoundInputView roundInputView, final RoundOutputView roundOutputView,
                                     final Generation generation) {
        return new RoundController(roundInputView, roundOutputView, generation);
    }

    public void run() {
        Round round = nextRound();
        while (!round.isOver()) {
            RoundInputDto roundInputDto = roundInputView.roundUserInput();
            List<Integer> userNumbers = roundInputDto.numbers();
            Balls userBalls = Balls.from(userNumbers);
            RoundOutputDto roundOutputDto = round.countResult(userBalls);
            roundOutputView.roundOutput(roundOutputDto);
        }
        roundOutputView.roundOverOutput();
    }

    private Round nextRound() {
        List<Integer> numbers = initializeRandomBalls();
        Balls balls = Balls.from(numbers);
        return Round.from(balls);
    }

    private List<Integer> initializeRandomBalls() {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < BASEBALL_LENGTH) {
            int systemNumber = generation.generate();
            set.add(systemNumber);
        }
        return new ArrayList<>(set);
    }

}

package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Generation;
import baseball.domain.Round;
import baseball.dto.RoundInputDto;
import baseball.dto.RoundOutputDto;
import baseball.view.RoundInputView;
import baseball.view.RoundOutputView;

import java.util.List;

public class RoundController {

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
        Round round = Round.nextRound(generation);
        int strike;

        do {
            RoundInputDto roundInputDto = roundInputView.roundUserInput();
            List<Integer> userNumbers = roundInputDto.numbers();
            Balls userBalls = Balls.from(userNumbers);
            RoundOutputDto roundOutputDto = round.countResult(userBalls);
            strike = roundOutputDto.strike();
            roundOutputView.roundOutput(roundOutputDto);
        } while (!round.hasEnough(strike));

        roundOutputView.roundOverOutput();
    }

}

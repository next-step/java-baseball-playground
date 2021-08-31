package baseball.view;

import baseball.dto.RoundOutputDto;

public interface RoundOutputView {
    void roundOutput(RoundOutputDto roundOutputDto);

    void roundOverOutput();
}

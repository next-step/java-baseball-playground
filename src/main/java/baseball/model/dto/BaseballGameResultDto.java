package baseball.model.dto;

public class BaseballGameResultDto {

    private final Integer strikes;

    private final Integer balls;

    private final Boolean nothing;

    private final Boolean complete;

    public BaseballGameResultDto(Integer strikes, Integer balls, Boolean nothing, Boolean complete) {
        this.strikes = strikes;
        this.balls = balls;
        this.nothing = nothing;
        this.complete = complete;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public Integer getBalls() {
        return balls;
    }

    public Boolean getNothing() {
        return nothing;
    }

    public Boolean getComplete() {
        return complete;
    }
}

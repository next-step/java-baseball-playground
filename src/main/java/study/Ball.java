package study;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Ball {
    private int position;
    private int value;

    Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public ResultType getStatus(List<Ball> list) {
        for (Ball element: list) {
            if (this.value == element.getValue() && this.position == element.position) {
                return ResultType.STRIKE;
            } else if (this.value == element.getValue()) {
                return ResultType.BALL;
            }
        }
        return ResultType.NOTHING;
    }
}

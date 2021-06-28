package study;

import lombok.Data;

@Data
public class ResultDTO {
    int ballValue = 0;
    int strikeValue = 0;
    ResultDTO() {}
    ResultDTO(int ballValue, int strikeValue) {
        this.ballValue = ballValue;
        this.strikeValue = strikeValue;
    }
}

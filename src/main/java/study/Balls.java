package study;

import lombok.Data;

import java.util.List;
@Data
public class Balls {
    private List<Ball> list;
    Balls (List<Ball> list) {
        this.list = list;
    }
}

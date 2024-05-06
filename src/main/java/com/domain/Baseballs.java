package com.domain;

import com.ui.Output;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseballs {
    private static final int Valid_Baseball_Size = 3;
    private static final int Zero_Start_Index = 0;
    private static final int Exist_Number = 1;

    private final List<Baseball> baseballs;

    public Baseballs(List<Baseball> baseballs){
        isValidSize(baseballs);
        isDuplicate(baseballs);

        this.baseballs = baseballs;
    }

    private void isValidSize(List<Baseball> baseball){
        if (baseball.size() != Valid_Baseball_Size) {
            throw new IllegalArgumentException(Output.BASEBALLS_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void isDuplicate(List<Baseball> baseballs){
        if (baseballs.stream().distinct().count() != Valid_Baseball_Size){
            throw new IllegalArgumentException(Output.BASEBALLS_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public int countStrike(Baseballs cmpBaseballs) {
        int strikeCount = 0;

        for (int i = 0; i < Valid_Baseball_Size; i++) {
            if (baseballs.get(i).equals(cmpBaseballs.baseballs.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(Baseballs cmpBaseballs) {
        int ballCount = 0;

        for (int i = 0; i < Valid_Baseball_Size; i++) {
            if (!baseballs.get(i).equals(cmpBaseballs.baseballs.get(i)) &&
                    cmpBaseballs.baseballs.contains(this.baseballs.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseballs baseballs = (Baseballs) o;
        return Valid_Baseball_Size ==
                IntStream.range(Zero_Start_Index, Valid_Baseball_Size)
                        .filter(i -> this.baseballs.get(i).equals(baseballs.baseballs.get(i)))
                        .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballs);
    }

}

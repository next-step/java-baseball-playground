package com.domain;

import com.ui.Output;

import java.util.Objects;

public class Baseball {
    private static final int Min_Number = 1;
    private static final int Max_Number = 9;

    private final int baseballNumber;

    public Baseball(int baseballNumber){
        isValidBaseballNumber(baseballNumber);

        this.baseballNumber = baseballNumber;
    }

    private void isValidBaseballNumber(int baseballNumber){
        if (baseballNumber < Min_Number || baseballNumber > Max_Number){
            throw new IllegalArgumentException(Output.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this ==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return baseballNumber == baseball.baseballNumber;
    }

    @Override
    public int hashCode(){
        return Objects.hash(baseballNumber);
    }

}

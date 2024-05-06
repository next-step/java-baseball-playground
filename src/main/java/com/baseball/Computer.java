package com.baseball;

import com.domain.BaseballFactory;
import com.domain.Baseballs;

public class Computer {
    public Baseballs generateTandomBaseballs(){
        return BaseballFactory.createRandomBaseballs();
    }
}

package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

public class ResultView {

    public void message(){

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public Boolean resumeMessage() {

        InputView inputView = new InputView();

        inputView.message();

        return false;

    }

    public Boolean exitMessage() {

        System.out.println("종료되었습니다.");

        return true;

    }
}

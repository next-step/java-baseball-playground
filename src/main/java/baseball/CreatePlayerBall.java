package baseball;

import java.util.Scanner;

public class CreatePlayerBall {
    private String manChoose;

    void createPBall(){
        Scanner sc = new Scanner(System.in);
        this.manChoose = sc.next();
    }

    public String getManChoose() {
        return manChoose;
    }
}

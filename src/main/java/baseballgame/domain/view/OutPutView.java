package baseballgame.domain.view;

import baseballgame.domain.PlayResult;

import java.util.Scanner;

public class OutPutView {
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printResult(PlayResult result) {
        System.out.println(buildResultView(result));
        System.out.println();
    }
    public static void printGameEnd(){
        System.out.println(GAME_END);

    }

    private static StringBuilder buildResultView(PlayResult playResult) {
        StringBuilder stringBuilder = new StringBuilder();

        if (playResult.getBall() != 0) {
            stringBuilder.append(" 볼 : " + playResult.getBall());
        }
        if (playResult.getStrike() != 0) {
            stringBuilder.append(" 스트라이크 : " + playResult.getStrike());
        }
        if(stringBuilder.isEmpty()){
            stringBuilder.append("나씽");
        }
        return stringBuilder;
    }
}

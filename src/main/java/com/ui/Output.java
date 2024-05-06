package com.ui;

public class Output {
    private static final String REQUIRE_NUMBER_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String REQUIRE_RESTART_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CORRECT_ANSWER_AND_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    public static final String BASEBALLS_SIZE_EXCEPTION_MESSAGE = "3자리 수를 입력해야 합니다.";
    public static final String BASEBALLS_DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자가 존재합니다.";
    public static final String INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE = "각 자리의 수는 1부터 9까지의 숫자만 가능합니다.";
    public static final String NULL_EXCEPTION_MESSAGE = "입력이 NULL이 될 수 없습니다.";
    public static final String RESUME_INPUT_SIZE_EXCEPTION_MESSAGE = "입력한 문자의 길이가 1을 넘을 수 없습니다.";
    public static final String RESUME_INPUT_FORMAT_EXCEPTION_MESSAGE = "입력은 1 또는 2만 가능합니다.";
    public static final String RESULT_NOTHING_MESSAGE = "낫싱";
    public static final String RESULT_STRIKE_MESSAGE = " 스트라이크 ";
    public static final String RESULT_BALL_MESSAGE = " 볼";

    public static void printRequestNumberInput() {
        System.out.print(REQUIRE_NUMBER_INPUT_MESSAGE);
    }

    public static void printRequestResumeInput() {
        System.out.println(REQUIRE_RESTART_INPUT_MESSAGE);
    }

    public static void printBaseballGameResult(String result) {
        System.out.println(result);
    }

    public static void printCorrectAnswer() {
        System.out.println(CORRECT_ANSWER_AND_EXIT_MESSAGE);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}

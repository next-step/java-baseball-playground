package study.baseballfortdd;

public enum BallMessage {
    NINETOONE("1 ~ 9 까지의 숫자를 입력하세요"),
    PUTTHREE("3자리 숫자를 입력하세요"),
    HOMERUN("홈런입니다."),
    PUTTHENUMBER("숫자를 입력하세요");

    public String feild;
    BallMessage(String feild) {
        this.feild = feild;
    }
}

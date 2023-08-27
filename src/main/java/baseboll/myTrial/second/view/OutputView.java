package baseboll.myTrial.second.view;

public class OutputView {
    public void nothing(){
        System.out.println("낫싱");
    }
    public void gameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void sendOutput(String checkResult){
        if (checkResult.equals("정답")) {
            gameEnd();
            return;
        }
        if (checkResult.equals("낫싱")) {
            nothing();
            return;
        }
        if (checkResult.equals("")) return;
        System.out.println(checkResult);
    }
}

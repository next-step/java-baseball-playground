package baseboll.myTrial.second.checker;

public class NothingChecker extends Checker{

    public boolean isNothing(int strikeCount, int ballCount){
        return strikeCount == 0 && ballCount == 0;
    }
}

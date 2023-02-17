package numberBaseballGame;

import java.util.Arrays;

public class UserAnswer {

    public UserAnswer(String answer){
        validation(answer);
    }

    public void validation(String answer){
        if( answer.length() != 3 ){
            throw new IllegalArgumentException("3글자가 아닙니다");
        }

        long distinctCount = Arrays.stream(answer.split(""))
                .distinct()
                .count();
        if( distinctCount != 3 ){
            throw new IllegalArgumentException("중복된 값은 입력하실 수 없습니다");
        }
    }
}

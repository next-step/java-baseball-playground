import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @Test
    void 정답이_맞는지_확인(){
        List<String> answer = new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> number = new ArrayList<>(Arrays.asList("1","2","3"));

        assertThat(Answer.correctAnswer(answer,number)).isTrue();
    }

    @Test
    void 정답이_틀리는지_확인(){
        List<String> answer = new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> number = new ArrayList<>(Arrays.asList("1","2","4"));

        assertThat(Answer.correctAnswer(answer,number)).isFalse();
    }
}
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    Answer answer;
    @Test
    void 정답이_맞는지_확인(){
        List<String> randoms = new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> numbers = new ArrayList<>(Arrays.asList("1","2","3"));
        
        
        assertThat(answer.correctAnswer(randoms,numbers)).isTrue();
    }

    @Test
    void 정답이_틀리는지_확인(){
        List<String> randoms = new ArrayList<>(Arrays.asList("1","2","3"));
        List<String> number = new ArrayList<>(Arrays.asList("1","2","4"));

        assertThat(answer.correctAnswer(randoms,number)).isFalse();
    }
}
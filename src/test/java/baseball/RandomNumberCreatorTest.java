package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomNumberCreatorTest {
    @Test
    @DisplayName("1~9 사이의 랜덤 값을 반환하는 메소드 테스트")
    void makeRandomNumber(){
        assertThat(RandomNumberCreator.makeRandomNumber(9)+1).isLessThan(10);
        assertThat(RandomNumberCreator.makeRandomNumber(9)+1).isGreaterThan(0);
    }

    @Test
    @DisplayName("중복값이 없는 숫자 리스트를 반환하는 메소드 테스트")
    void makeNumberList(){
        List<Integer> list = RandomNumberCreator.makeNumberList();
        for(int num : list){
            assertThat(list.lastIndexOf(num) == list.indexOf(num)).isTrue();
        }
    }

}

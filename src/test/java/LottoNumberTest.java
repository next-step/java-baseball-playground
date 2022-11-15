import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void 숫자가3개나오는지확인(){
        final List<String> strings = LottoNumber.makeLottoNumbers();

        assertThat(strings.size()).isEqualTo(3);
    }

    @Test
    @RepeatedTest(10)
    void 중복되지않은_숫자_3개_인지를_확인(){
        final List<String> numbers = LottoNumber.makeLottoNumbers();
        final Set<String> threeNumbers = new HashSet<>(numbers);

        assertThat(threeNumbers.size()).isEqualTo(3);
    }
}
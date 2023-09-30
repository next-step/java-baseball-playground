import number_generator.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    NumberGenerator numberGenerator;
    @BeforeEach
    void init(){
        numberGenerator = new NumberGenerator();
    }
    @Test
    void generate_length3_string(){
        String number = numberGenerator.generateNumber();
        assertThat(number).hasSize(3);
    }

    @Test
    void notDuplicatedTest(){
        String generateNumber = numberGenerator.generateNumber();
        Set<Character> characterSet = new HashSet<>();
        for (char c : generateNumber.toCharArray()) {
            characterSet.add(c);
        }
        assertThat(characterSet).hasSize(3);
    }
}

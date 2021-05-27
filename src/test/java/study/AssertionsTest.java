package study;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class AssertionsTest {

    static class Dog {
        private String name;
        private float weight;

        public Dog(String name, float weight) {
            this.name = name;
            this.weight = weight;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setWeight(float weight) {
            this.weight = weight;
        }
        public float getWeight() {
            return this.weight;
        }
    }

    @Test
    void ObjectAssertions() {
        Dog fido = new Dog("Fido", 5.25f);
        Dog fidoClone = new Dog("Fido", 5.25f);

        assertThat(fido).isNotEqualTo(fidoClone);
        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidoClone); // deprecated
    }

    @Test
    void BooleanAssertions() {
        assertThat("".isEmpty()).isTrue();
    }

    @Test
    void ArrayAssertions() {
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        assertThat(list).contains("2");
        assertThat(list).contains("3");
        assertThat(list).isNotEmpty();
        assertThat(list).startsWith("1");
    }

    @Test
    void CharacterAssertions() {
        char someCharacter = 'c';
        assertThat(someCharacter)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }

    @Test
    void ClassAssertions() {
        assertThat(Runnable.class).isInterface();
        assertThat(Dog.class).isNotInterface().isNotFinal();
    }

    @Test
    void FileAssertions() {
        File file = new File("README.md");
        assertThat(file)
                .isFile()
                .exists()
                .canRead()
                .canWrite();
    }

    @Test
    void NumberAssertions() {
        assertThat(5.3).isEqualTo(5, withPrecision(3d));
    }

    @Test
    void InputStreamAssertions() {
        // assertThat(given).hasSmaeContentAs(exptected);
    }

    @Test
    void MapAssertions() {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("a", 1);
        assertThat(maps)
                .isNotEmpty()
                .containsKey("a")
                .doesNotContainKey("b")
                .contains(entry("a", 1));
    }

    @Test
    void ThrowableAssertions() {
        // assertThat(new Throwable()).hasNoCause().hasMessageEndingWith("c");
    }
    
    @Test
    void DescribingAssertions() {
        Dog dog = new Dog("치와와", 10.5f);
        assertThat(dog.getWeight())
                .as("%s's weight should be equal to 100", dog.getName())
                .isEqualTo(100f);
    }

}

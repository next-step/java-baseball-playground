package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.print.Doc;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

/**
 * https://www.baeldung.com/introduction-to-assertj
 * 아래 테스트는 위 AssertJ 문서의 테스트 코드이다.
 */
public class AssertJTest {

    @Test
    public void assertTest(){
        // 아래 문법만으로는 실제로는 아직 아무것도 주정하지 않아 실패하지 않는다.
        assertThat(100);
    }


    @Test
    public void assertTestBoolean(){
        // assertThat으로 Boolean 값을 비교할 수 있다.
        assertThat("".isEmpty()).isTrue();
    }


    @Test
    public void assertTestList(){
        // Iterable/Array에서 포함 관계 검색 방법
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");

        // List가 비어있지 않은 경우
        assertThat(list).isNotEmpty();

        // List가 “1”로 시작하는 경우
        assertThat(list).startsWith("1");

        // List가 비어있지 않고, 1을 포함하며 null을 포함하고 있지 않으며 “2”, “3”을 포함하는지 확인하는 방법
        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }

    @Test
    public void assertTestCharacter(){
        // Character가 ‘a’와 동일하지 않고, 유니코드 테이블에 있으며 ‘b’보다 크고 소문자인지
        Character someCharacter = 'c';
        assertThat(someCharacter)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }

    @Test
    public void assertThatClass(){
        // Runnable 클래스가 인터페이스인지 확인
        assertThat(Runnable.class).isInterface();

        // Exception 클래스가 NoSuchElementException으로부터 할당 가능한지 확인
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }

    @Test
    public void assertThatFile(){
        // 파일 Assertions은 주어진 File이 존재하는지, 디렉토리 또는 파일인지, 특정 콘텐츠가 있는지, 읽을 수 있는지 또는 확장자가 있는지 확인한다.
        File someFile = new File("file.txt");
        try {
            if(someFile.createNewFile()){
                System.out.println("파일 생성 성공");
            } else {
                System.out.println("이미 존재하는 파일입니다.");
            }
        } catch (IOException e) {
            System.out.println("파일 생성 시 에러 발생: " + e.getMessage());
        }
        assertThat(someFile)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    @Test
    public void assertNumeric(){
        // Numeric Assertions는 offset이 주어지거나 주어지지 않은 숫자를 비교한다. 예를 들어 주어진 정밀도(preecision)에 따라 두 값이 같은지 확인할 경우는 아래와 같이 할 수 있다.
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
    }

    @Test
    public void assertMap(){
        // 주어진 맵이 비어 있지 않은지, 숫자 키 ”2”를 포함하고, 숫자 키 “10”을 포함하지 않으며 key 2와 value “a”를 포함하는지 확인한다.
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "a");
        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(2, "a"));
    }

    @Test
    public void assertThrow(){
        // 주어진 예외가 발생하고 “c”로 끝나는 메시지가 있는지 확인한다.
        Exception ex = new Exception("c");
        assertThat(ex).hasNoCause().hasMessageEndingWith("c");
    }

    @Test
    public void assertThrowDetail(){
        Integer age = 30;
        String name = "Ela";
        // 더 상세한 내용의 Assertion을 작성하기 위해서는  “as”를 사용할 수 있다.
        assertThat(age)
                .as("%s's age should be equal to 100", name)
                .isEqualTo(100);
    }

}

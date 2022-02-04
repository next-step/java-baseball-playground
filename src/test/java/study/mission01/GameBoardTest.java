package study.mission01;

import org.junit.jupiter.api.*;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("게임보드 객체 핵심 로직 구현테스트")
class GameBoardTest {

    private GameBoard gameBoard;
    private int answer;     // answer = 971

    /**
     * todo
     * 랜덤 숫자인데 실행 할 때마다 answer = 971 이 나옴
     *
     */
    @BeforeEach
    @DisplayName("랜덤 숫자 생성 객체")
    void 랜덤숫자_생성() {
        gameBoard = new GameBoard();
        answer = gameBoard.getAnswer();
    }

    @Test
    @DisplayName("파라미터로 전달하는 정수를 자리 수 key, 자리 원소 value 로 map 에 저장한다.")
    void 정수를_자리수대로_key_value로_저장() {
        // given
        int number = 713;
        // when
        Map<Integer, Integer> map = GameBoard.convertNumberToArray(number);
        // then
        assertEquals(7, map.get(100));
        assertEquals(1, map.get(10));
        assertEquals(3, map.get(1));
    }

    /**
     * todo
     * 힌트 메소드가 스트라이크, 볼, 낫띵 판단을 같이 하므로 판단 로직만 따로 테스트를 할 수가 없다.
     * 전부 뜯어야 한다.
     * 힌트 메소드가 가지고 있는 역할:
     * 1.answer, guessNumber 를 map 으로 반환해주는 기능.
     * 2.스트라이크, 볼, 낫띵을 판단하는 기능
     *
     *
     */
     // * answer 값이 고정 되어 있을 때 검증하는 테스트 (answer = 971)
    @TestFactory
    @DisplayName("힌트 메소드가 스트라이크를 반환하는지 테스트한다.")
    Stream<DynamicTest> 스트라이크를_반환하는_힌트_메소드() {
        // answer = 971;
        StrikeTestCase oneStrike = new StrikeTestCase(576, "1strike");
        StrikeTestCase twoStrike = new StrikeTestCase(931, "2strike");
        StrikeTestCase threeStrike = new StrikeTestCase(971, "3strike");

        return Stream.of(oneStrike, twoStrike, threeStrike)
                .map(strikeTestCase -> DynamicTest.dynamicTest(
                        "테스트 할 정수는 " + strikeTestCase.testNumber + " 이고 예상하는 결과는 " + strikeTestCase.expectedHint + " 이다.",
                        () -> {
                            Map<String, String> hint = gameBoard.getHint(strikeTestCase.testNumber);
                            for (String key : hint.keySet()) {
                                assertEquals(strikeTestCase.expectedHint, hint.get(key) + key);
                            }

                        }
                ));

    }


    private class StrikeTestCase {
        private final int testNumber;
        private final String expectedHint;

        public StrikeTestCase(int testNumber, String expectedHint) {
            this.testNumber = testNumber;
            this.expectedHint = expectedHint;
        }
    }
}
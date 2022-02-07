## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 숫자야구게임 구현

### BaseBall
```java
public interface BaseBall {
    public void startGame();
    public boolean resultValue();
    public void inputValue(String value);
}
```

### BaseBallImpl
```java
public class BaseBallImpl implements BaseBall{
    private static final int  GAME_SIZE = 3;
    private  String result;
    private int strike;
    private int ball;

    @Override
    public boolean resultValue() {
        if (strike == GAME_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
        return false;
    }

    @Override
    public void inputValue(String value) {
        System.out.println("value = " + value);
        checkValue(value);
    }

    private void checkValue(String value) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < GAME_SIZE; i++) {
            checkStrikeOrBall(value, i);
        }
    }

    private void checkStrikeOrBall(String value, int i) {
        String valueOf = String.valueOf(value.charAt(i));
        String resultOf = String.valueOf(result.charAt(i));
        if (resultOf.equals(valueOf)) {
            strike += 1;
        }
        if (!resultOf.equals(valueOf)
                && result.contains(valueOf)) {
            ball += 1;
        }
    }

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String next = scanner.next();
            this.inputValue(next);
        } while (!this.resultValue());
    }

    public void setResult() {
        String [] resultList = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        this.result = "";
        do {
            int temp = (int) (Math.random() * 100) % resultList.length;
            checkDuplicated(resultList, temp);
        } while (result.length() < 4);
    }

    private void checkDuplicated(String[] resultList, int temp) {
        if (!result.contains(resultList[temp])) {
            result += resultList[temp];
        }
    }

    public BaseBallImpl() {
        setResult();
    }
}
```

### BaseBallImplTest
```java
class BaseBallImplTest {

    BaseBall baseBall;


    @BeforeEach
    void setUp() {
        baseBall = new BaseBallImpl();

    }

    public void startTestGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String next = scanner.next();
        baseBall.inputValue(next);
    }

    private void baseBallGameForTest(String value) {
        InputStream in = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        this.startTestGame();
    }

    @Test
    @DisplayName("resultValue()")
    void resultValue() {
        String value = "123";
        baseBallGameForTest(value);
        baseBall.resultValue();
    }

    @Test
    @DisplayName("inputValue()")
    void inputValue() {
        String value = "345";
        baseBallGameForTest(value);

        String result = "value = 345";
    }

    @Test
    @DisplayName("베이스볼 게임")
    void testBaseball() {
        int value = 111;
        do {
            String string_value = String.valueOf(value);
            baseBallGameForTest(string_value);
            value += 1;
        }while (!baseBall.resultValue());
    }
}
```
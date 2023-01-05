package baseball;

import java.util.*;

/**
 * 프로그래밍 요구사항
 *
 * 자바 코드 컨벤션을 지키면서 프로그래밍한다.
 *  - 기본적으로 Google Java Style Guide을 원칙으로 한다.
 *  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
 * indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
 *  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
 *  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
 * else 예약어를 쓰지 않는다.
 *  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
 *  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
 * 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
 *  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
 *  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
 * 3항 연산자를 쓰지 않는다.
 * 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
 */
public class BaseballGame {

    public void start() {
        boolean isStart = true;
        List<Integer> answer = null;

        while (true) {
            // 서로 다른 수로 이루어진 3자리의 수 생성
            if (isStart) {
                Random random = new Random();
                Set<Integer> set = new HashSet<>();
                while (set.size() < 3) {
                    set.add(random.nextInt(9) + 1);
                }
                answer = new ArrayList<>(set);
                isStart = false;
            }

            // 숫자 입력
            System.out.print("숫자를 입력해 주세요 : ");
            Scanner kb = new Scanner(System.in);
            String input = kb.nextLine();

            // 입력받은 값이 숫자인지 검증
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalStateException("숫자만 입력할 수 있습니다.");
            }

            // 정답과 입력 값 비교
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                int num = Character.getNumericValue(input.charAt(i));

                if (answer.get(i) == num) {
                    strike++;
                } else if (answer.contains(num)) {
                    ball++;
                }
            }

            // 비교 결과 생성
            StringBuilder sb = new StringBuilder();
            if (ball > 0) {
                sb.append(ball).append("볼 ");
            }
            if (strike > 0) {
                sb.append(strike).append("스트라이크");
            }
            if (sb.length() == 0) {
                sb.append("낫싱");
            }

            // 결과 출력
            System.out.println(sb);

            // 정답여부 확인
            if (sb.toString().contains("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // 진행 여부 확인
                while (true) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int i = kb.nextInt();
                    if (i == 1) {
                        isStart = true;
                        break;
                    } else if (i == 2) {
                        System.exit(0);
                    }
                }
            }
        }
    }
}

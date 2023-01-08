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
---
## 프로그래밍 요구사항
1. 자바 코드 컨벤션을 지키면서 프로그래밍한다.
2. 기본적으로 Google Java Style Guide을 원칙으로 한다.
> 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
3. indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
> 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
> 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
4. else 예약어를 쓰지 않는다.
> 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.  
else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
5. 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
> 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.  
> UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
6. 3항 연산자를 쓰지 않는다.
7. 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
---
## 기능 목록 및 commit 로그 요구사항
### ⚙️ 기능 목록 
- 컴퓨터에서 랜덤으로 서로 다른 3자리 숫자를 생성한다
- 사용자에게 서로 다른 3자리 숫자를 입력받는다
- 입력받은 숫자에 대해서 힌트를 제공한다
  - 스트라이크 : 같은 수가 같은 자리에 있는 경우
  - 볼 : 같은 수가 다른 자리에 있는 경우
  - 낫싱 : 같은 수가 전혀 없는 경우
- 만약 3개의 숫자를 모두 맞힌 경우 -> 게임 종료
- 게임 종료 후 -> 완전히 종료(0 입력)하거나 새로운 게임 시작

### 🚀 commit 로그 요구사항
**commit message convention** 
```성
// head
<type> : [<step information>] <short description>

//body
description (option)
```

**type**
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

**요구사항**
- 하나의 메소드(기능)가 완성될 때마다 커밋한다
- 커밋은 꼭 컨벤션에 맞춰서 작성한다

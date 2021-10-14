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

## 기능 요구사항
- [x] 길이가 3인 랜덤 숫자를 만들어야 한다.
  - [x] 중복이 없어야 한다.
  - [x] 1~9 사이의 값으로 이루어져야한다.
- [x] 사용자가 길이가 3인 숫자를 입력할 수 있어야한다.
- [x] 스트라이크, 볼, 낫싱을 판별해야한다.
  - [x] 같은 위치에 같은 값 : 스트라이크
  - [x] 다른 위치에 같은 값 : 볼
  - [x] 같은게 없을 경우 : 낫싱
- [x] 게임이 종료된 이후 다시 실행하거나 완전히 종료할수 있어야 한다.


## 프로그래밍 요구사항
- 인덴트 depth는 1로 제한한다.
- else 예약어를 사용하지 않는다.
- 모든 로직에 단위 테스트를 구현한다.(UI 로직은 제외)
- 3항 연산자를 사용하지 않는다.
- 하나의 메소드가 한가지 일만 하도록 최대한 작게 만든다.
- 커밋 메세지를 컨벤션에 따라 작성할 것.


## 피드백

--- 
- 만약 야구공이 아닌 축구공, 농구공이 된다면..? -> 최소한의 코드 수정을 고려해볼것.
- 랜덤 메소드 테스트는 어떻게?
- 사용자의 인풋값에 따른 예외처리
- 접근제어자를 적절하게 사용할것.
- 뷰를 관장하는 애를 따로 둘것.


### 설계

---
1. 랜덤 숫자를 만드는 행위 -> RandomNumberCreator
2. 랜덤 숫자의 범위를 검증하는 행위 -> RandomNumberCreator
3. 랜덤 숫자의 중복을 검증하는 행위 -> RandomNumberCreator
4. 1개의 야구공을 만드는 행위 -> Ball
5. 3개의 야구공 세트로 만드는 행위 -> Balls 
6. 스트라이크, 볼, 낫싱을 검증하는 행위 -> Referee
7. 결과를 출력하는 행위 -> Referee
8. 사용자의 입력값을 받는 행위 -> User
9. 게임의 실행 종료를 관리하는 행위 -> Application


- 랜덤한 메소드는 최상단에서 인자값을 넘겨주어서 해당 인자값 내의 값인지만 테스트해서 랜덤값 테스트하자.

## MVC 패턴

---
- Controller
  - Application
  - BaseballgameController
  
- Model - 검증하는 로직 같은 비즈니스 로직은 모델에서!!
  - Balls
  - Ball
  - Referee
  - User?

- View
  - InputView
  - OutputView
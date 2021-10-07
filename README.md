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
- [ ] 사용자가 길이가 3인 숫자를 입력할 수 있어야한다.
- [ ] 스트라이크, 볼, 낫싱을 판별해야한다.
  - [ ] 같은 위치에 같은 값 : 스트라이크
  - [ ] 다른 위치에 같은 값 : 볼
  - [ ] 같은게 없을 경우 : 낫싱
- [ ] 게임이 종료된 이후 다시 실행하거나 완전히 종료할수 있어야 한다.


## 프로그래밍 요구사항
- 인덴트 depth는 1로 제한한다.
- else 예약어를 사용하지 않는다.
- 모든 로직에 단위 테스트를 구현한다.(UI 로직은 제외)
- 3항 연산자를 사용하지 않는다.
- 하나의 메소드가 한가지 일만 하도록 최대한 작게 만든다.
- 커밋 메세지를 컨벤션에 따라 작성할 것.


## 클래스 설계
- RandomNumberCreator
  - makeRandomNumber : 랜덤 숫자 만들기
  - validateOverlap : 중복 체크
  - validateRange : 범위 체크
- BallStatus(enum)
  - Strike, Ball, Nothing 을 가진다.
  - 상태와 행위가 한곳에서 이루어지도록 연산식을 enum에서 처리하자.
  - 상태에 따른 행동을 여기서 정의.
- Ball
  - 하나의 숫자를 상태로 갖는다.
  - equal : 상태 비교
- Balls
  - Ball 객체를 가진 List를 상태로 갖는다.
  - 매개값으로 받은 숫자로 Ball객체를 담은 List 상태에 저장하는 생성자
  - 각 Ball을 비교하며 검사하는 로직
- User
  - input을 받는 메소드
  - input을 사용하여 Balls를 만드는 로직
- Application
  - main 메소드
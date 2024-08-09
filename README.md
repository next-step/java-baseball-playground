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
4. 구현할 기능 목록

### InputView
```jsx
- 3자리의 난수 생성 (조건 : 각 숫자가 겹치지 않는다)
- 사용자의 입력값 받고 저장
    - 입력값 검증 : 
        - 3자리의 각 자리가 중복이 안되는지,
        - 1~9 사이의 수 인지
```
### NumbersBaseball
```jsx
- 난수와 입력값 비교
    - 같은 위치에 같은 숫자라면 strike
    - 다른 위치에 같은 숫자가 있으면 ball
    - 아무것도 겹치지 않으면 낫싱
- 3 strike가 아니라면 다시 입력값 받기
- 3 strike라면 게임이 끝
- 게임을 다시 시작하거나 완전히 종료할 수 있다
```
### ResultView
```jsx
- strike, ball, nothing 점수 혹은 결과 출력
- 3 strike일 때 종료 메세지 출력
```

